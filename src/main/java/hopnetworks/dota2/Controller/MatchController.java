package hopnetworks.dota2.Controller;



import com.alibaba.fastjson.JSONArray;
import com.mongodb.DBObject;

import com.mongodb.util.JSON;
import hopnetworks.dota2.DAO.MatchModelRepository;
import hopnetworks.dota2.DAO.MatchRepository;
import hopnetworks.dota2.DAO.PlayerRepository;
import hopnetworks.dota2.DAO.TeamRepository;
import hopnetworks.dota2.Model.PlayerModel;

import hopnetworks.dota2.Utils.HttpRequestUtil;
import hopnetworks.dota2.Utils.ResourceBundleUtil;
import hopnetworks.dota2.domain.Match;
import hopnetworks.dota2.domain.MatchModel;
import hopnetworks.dota2.domain.Player;
import hopnetworks.dota2.domain.Team;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
@Autor zhuoyj[hopnetworks]
@Date 2018/10/18
@function 比赛记录的API控制器
@Description

*/
@Controller
public class MatchController {
@Autowired
    private MatchRepository matchRepository;
@Autowired
private MatchModelRepository matchModelRepository;
    @Resource
    private MongoTemplate mongoTemplate;

@Autowired
    HttpRequestUtil httpRequestUtil;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    final static String dotaApi=  ResourceBundleUtil.getSystemString("dotaApi") ;//APi 服务器地址
    final static String defaultTeamId=  ResourceBundleUtil.getSystemString("defaultTeamId") ;//私钥
    private  static ObjectId defaultTeamObjectId=new ObjectId(defaultTeamId);
    @RequestMapping(value = "/insertmatch")
@ResponseBody
    public boolean inserMatch(int  matchId){
    Team team=new Team();
    Player player=new Player();

    Match match=new Match();
    ObjectId winTeamObjectId=null;
    ObjectId loseTeamObjectId=null;
    //两个队伍的objectId,即teamId
    String url = dotaApi+"api/matches/"+matchId;
    System.out.println(url);
    //post请求
    HttpMethod method =HttpMethod.GET;
    // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
    MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
  //  params.add("access_token", "xxxxx");
    //发送http请求并返回结果
    String result= httpRequestUtil.client(url,method,params);
    DBObject matchJson=(DBObject) JSON.parse(result);//将返回结果转换成可供DB存储的数据
    DBObject playersJson=(DBObject)matchJson.get("players");

     match= com.alibaba.fastjson.JSON.parseObject(matchJson.toString(), Match.class);
    match.setMatchId(matchId);

    List<PlayerModel> playerModel= com.alibaba.fastjson.JSON.parseArray(playersJson.toString(),PlayerModel.class);

//jsonArray.toJavaObject(PlayerModel);
    //保存10位选手的数据

        for (int i = 0; i < 10; i++) {
            try {
            player = playerRepository.findByAccountId(playerModel.get(i).getAccount_id());
            if (player == null) {
                player=new Player();
                System.out.println(i+"名选手数据为空");
                BeanUtils.copyProperties(playerModel.get(i),player);
                winTeamObjectId=loseTeamObjectId=defaultTeamObjectId;
                player.setTeamId(defaultTeamObjectId);
                player.setAccountId(i);
          //   player.setTeamId();
            }
            else {
                BeanUtils.copyProperties(playerModel.get(i), player);
                player.setKillsSum(player.getKillsSum() + playerModel.get(i).getKills());
                player.setDeathsSum(player.getDeathsSum() + playerModel.get(i).getDeath());
                player.getMatchIdList().add(playerModel.get(i).getMatch_id());
                player.setAssistsSum(player.getAssistsSum()+playerModel.get(i).getAssists());
                System.out.println(player);
                if (player.getWin() == 1) {
                    player.setIntegration(player.getIntegration() + 1);
                    if (winTeamObjectId == null) {

                        winTeamObjectId = player.getTeamId();
                    }
                } else {
                    if (loseTeamObjectId == null) {
                        loseTeamObjectId = player.getTeamId();
                    }
                }

            }   //jsonArray.get(0).
            playerRepository.save(player);
       }catch (Exception e){

            System.out.println(e);
        }
    }

    try{
        //找到选手所在队伍
        team=teamRepository.findByTeamId( winTeamObjectId);
        if(team==null) {
            //有一名选手不在队伍中
            return false;
        }

         team.setIntegration(team.getIntegration()+1);
         team.setGameSum(team.getGameSum()+1);
match.setWin_team_name(team.getTeamName());
        Team anotherTeam=teamRepository.findByTeamId(loseTeamObjectId);
        if(loseTeamObjectId.equals(winTeamObjectId)){

        }else
        {anotherTeam.setGameSum(anotherTeam.getGameSum()+1);
            match.setLose_team_name(anotherTeam.getTeamName());
        }
        teamRepository.save(team);
        teamRepository.save(anotherTeam);

    }
    catch (Exception e){

        return false;
    }
    //DBObject bson=(DBObject) JSON.parse(result);
//System.out.println( JSON.parse(result).get("players"));

    matchRepository.save(match);
  System.out.println(result);
  return  true ;
}




    @RequestMapping(value = "/findallmatch")
    @ResponseBody
    public List<Match> findAllMatch(){
       // System.out.println( matchModelRepository.findAll().get(0).getMatchId());
        // teamRepository.findAll()
        return matchRepository.findAll() ;

    }

    @RequestMapping(value = "/deletematch")
    @ResponseBody
    public boolean delsteteam(int matchId){

        try {
            Criteria criteria = Criteria.where("matchId").is(matchId);
            Query query = new Query(criteria);
            mongoTemplate.remove(query,Match.class);
            System.out.println("根据ID删除成功");
        }
        catch (Exception e){

        }
        // teamRepository.findAll()
        return  true ;
    }
}
