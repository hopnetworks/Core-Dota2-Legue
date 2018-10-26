package hopnetworks.dota2.Controller;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import hopnetworks.dota2.DAO.PlayerRepository;
import hopnetworks.dota2.DAO.TeamRepository;
import hopnetworks.dota2.Utils.HttpRequestUtil;
import hopnetworks.dota2.domain.Player;
import org.bson.types.ObjectId;
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

import static hopnetworks.dota2.Controller.MatchController.dotaApi;

@Controller
public class PlayerController {
    @Autowired
    HttpRequestUtil httpRequestUtil;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Resource
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/insertplayer")
    @ResponseBody
    public int insertPlayer(String teamId,int  accountId){
        Player player=new Player();
//        String url = dotaApi+"api/players/"+accountId;
//
//        //post请求
//        HttpMethod method =HttpMethod.GET;
//        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
//        //  params.add("access_token", "xxxxx");
//        //发送http请求并返回结果
//        String result= httpRequestUtil.client(url,method,params);
//        DBObject matchJson=(DBObject) JSON.parse(result);//将返回结果转换成可供DB存储的数据
//        DBObject playersJson=(DBObject)matchJson.get("profile");
//        player.setName(playersJson.get("name").toString());
try{

    player.setAccountId(accountId);
    ObjectId objectId=new ObjectId(teamId);
    player.setTeamId(objectId);
return playerRepository.save(player).getAccountId();
}
catch (Exception e){
    return 0;
}
    }
        @RequestMapping(value = "/findbyteamid")
    @ResponseBody
    public List<Player> findPlayerByTeamId(String teamId){
            System.out.println(teamId);
        ObjectId objectId=new ObjectId(teamId);
        System.out.println(objectId);
        return playerRepository.findByTeamId(objectId);
    }
    @RequestMapping(value = "/deletebyteamid")
    @ResponseBody
    public boolean deletebyteamid(String teamId){
        ObjectId objectId=new ObjectId(teamId);

                teamRepository.delete(teamRepository.findByTeamId(objectId));
        return true;
    }

    @RequestMapping(value = "/deleteplayer")
    @ResponseBody
    public boolean delPlayer(int accountId){

        try {
            Criteria criteria = Criteria.where("accountId").is(accountId);
            Query query = new Query(criteria);
            mongoTemplate.remove(query,Player.class);
            System.out.println("根据ID删除成功");
        }
        catch (Exception e){

        }
        // teamRepository.findAll()
        return  true ;
    }
    @RequestMapping(value = "/findallplayer")
    @ResponseBody
    public List<Player> findallteam(){
        //  System.out.println(teamRepository.findAll().get(0).getTeamId());
        // teamRepository.findAll()
        return playerRepository.findAll() ;
    }
    }