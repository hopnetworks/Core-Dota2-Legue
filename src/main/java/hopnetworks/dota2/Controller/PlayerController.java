package hopnetworks.dota2.Controller;

import hopnetworks.dota2.DAO.PlayerRepository;
import hopnetworks.dota2.DAO.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @RequestMapping(value = "/insertplayer")
    @ResponseBody
    public String insertPlayer(String playerName,String teamId){

        return "";
    }
    @RequestMapping(value = "/insertteam")
    @ResponseBody
    public String insertTeam(String teamName,String teamId){

        return "";
    }
}
