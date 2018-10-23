package hopnetworks.dota2.Controller;

import hopnetworks.dota2.DAO.PlayerRepository;
import hopnetworks.dota2.DAO.TeamRepository;
import hopnetworks.dota2.domain.Player;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @RequestMapping(value = "/insertplayer")
    @ResponseBody
    public int insertPlayer(String playerName,String teamId,int  accountId){
        Player player=new Player();
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

}
