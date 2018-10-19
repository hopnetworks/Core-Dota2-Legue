package hopnetworks.dota2.Controller;



import com.mongodb.DBObject;

import com.mongodb.util.JSON;
import hopnetworks.dota2.DAO.MatchModelRepository;
import hopnetworks.dota2.DAO.MatchRepository;
import hopnetworks.dota2.DAO.PlayerRepository;
import hopnetworks.dota2.DAO.TeamRepository;
import hopnetworks.dota2.Utils.HttpRequestUtil;
import hopnetworks.dota2.domain.MatchModel;
import hopnetworks.dota2.domain.Player;
import hopnetworks.dota2.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public boolean inserMatvh(String matchId){
    Team team=new Team();
    Player player=new Player();
    MatchModel matchModel=new MatchModel();
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
    //DBObject bson=(DBObject) JSON.parse(result);
//System.out.println( JSON.parse(result).get("players"));
    teamRepository.save(team);
    matchModelRepository.save(matchModel);
  System.out.println(result);
  return  true ;
}







}
