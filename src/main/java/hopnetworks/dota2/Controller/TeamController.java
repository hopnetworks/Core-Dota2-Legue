package hopnetworks.dota2.Controller;

import hopnetworks.dota2.DAO.PlayerRepository;
import hopnetworks.dota2.DAO.TeamRepository;
import hopnetworks.dota2.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class TeamController {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @RequestMapping(value = "/insertteam")
    @ResponseBody
    public String insertTeam(String teamName)throws Exception
    {
        System.out.println(teamName);
Team team=new Team();
team.setTeamName(teamName);
        return teamRepository.save(team).getTeamId();
    }

    @RequestMapping(value = "/findallteam")
    @ResponseBody
    public List<Team> findallteam(){
        System.out.println(teamRepository.findAll().get(0).getTeamId());
       // teamRepository.findAll()
    return teamRepository.findAll() ;

    }

}
