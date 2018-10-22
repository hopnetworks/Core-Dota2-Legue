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
import hopnetworks.dota2.domain.MatchModel;
import hopnetworks.dota2.domain.Player;
import hopnetworks.dota2.domain.Team;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
@Autor zhuoyj[hopnetworks]
@Date 2018/10/18
@function 比赛记录的API控制器
@Description

*/
public class MatchController {
@Autowired
    private MatchRepository matchRepository;
@Autowired
private MatchModelRepository matchModelRepository;
@Autowired
    HttpRequestUtil httpRequestUtil;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

@RequestMapping(value = "/insertmatch")
@ResponseBody
    public boolean inserMatvh(int  matchId){
    Team team=new Team();
    Player player=new Player();
    MatchModel matchModel=new MatchModel();
    ObjectId teamObjectId=null;
    ObjectId anotherTeamObjectId=null;
    //两个队伍的objectId,即teamId
    String url = "https://api.opendota.com/api/matches/"+matchId;
    //post请求
    HttpMethod method =HttpMethod.GET;
    // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
    MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
  //  params.add("access_token", "xxxxx");
    //发送http请求并返回结果
    String result= httpRequestUtil.client(url,method,params);


    DBObject matchJson=(DBObject) JSON.parse(result);//将返回结果转换成可供DB存储的数据
    DBObject playersJson=(DBObject)matchJson.get("players");
    playersJson.get("0");
    System.out.println( playersJson.get("0"));
    team.setPlayersJson( playersJson);
   // player=playerRepository.findByAccount_id()
    matchModel.setMatchJson(matchJson);
    matchModel.setMatchId(matchId);
    JSONArray jsonArray = JSONArray.parseArray(playersJson.toString());
    List<PlayerModel> playerModel= com.alibaba.fastjson.JSON.parseArray(playersJson.toString(),PlayerModel.class);

//jsonArray.toJavaObject(PlayerModel);
    try {
        for (int i = 0; i < 10; i++) {

            player = playerRepository.findByAccountId(playerModel.get(i).getAccount_id());
            if (player == null) {
                BeanUtils.copyProperties(playerModel.get(i),player);
            }
            BeanUtils.copyProperties(playerModel.get(i),player);
            player.setKillsSum(player.getKillsSum()+playerModel.get(i).getKills());
            player.setDeathsSum(player.getDeathsSum()+playerModel.get(i).getDeath());
            player.getMatchIdList().add(playerModel.get(i).getMatch_id());
            System.out.println(player);
            if(teamObjectId==null){

                teamObjectId=player.getTeamId();
                anotherTeamObjectId=player.getTeamId();
            }

                if (teamObjectId.equals(anotherTeamObjectId)) {

                    anotherTeamObjectId=player.getTeamId();
                }



            if(player.getWin()==1){
                player.setIntegration(player.getIntegration()+1);
            }
playerRepository.save(player);
            //jsonArray.get(0).

        }
    }catch (Exception e){


    }
    for (int i = 0; i < 10; i++) {
        if (teamObjectId.equals(anotherTeamObjectId)) {

            anotherTeamObjectId=player.getTeamId();
        }
        break;
    }
    try{
        //找到选手所在队伍
        team=teamRepository.findByObjectId(player.getTeamId());
        if(team==null) {
            //有一名选手不在队伍中
            return false;
        }

        if(player.getWin()==1){
         team.setIntegration(team.getIntegration()+1);
         team.setGameSum(team.getGameSum()+1);
        }
        Team anotherTeam=new Team();
        if(player.getTeamId().equals(teamObjectId)){
         anotherTeam=teamRepository.findByObjectId(anotherTeamObjectId);
        }
        else{
       anotherTeam=teamRepository.findByObjectId(teamObjectId);
        }
        anotherTeam.setGameSum(anotherTeam.getGameSum()+1);

teamRepository.save(team);
        teamRepository.save( anotherTeam);
    }
    catch (Exception e){


    }
    //DBObject bson=(DBObject) JSON.parse(result);
//System.out.println( JSON.parse(result).get("players"));
    teamRepository.save(team);
    matchModelRepository.save(matchModel);
  System.out.println(result);
  return  true ;
}







}
