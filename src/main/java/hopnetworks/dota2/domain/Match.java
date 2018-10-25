package hopnetworks.dota2.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Match {

    @Id
    private int matchId;
    private String userName;
    private String passWord;


    private int barracks_status_dire;
    private int barracks_status_radiant;

    private int cluster;

    private int       dire_score,dire_team_id;

    private int       duration;
    private int     engine;
    private int       first_blood_time;
    private int         game_mode;
    private int       human_players;
    private int        leagueid;
    private int        lobby_type;
    private int          match_seq_num;
    private int           negative_votes;


    private int          positive_votes;

    private int            radiant_score;

    private      boolean     radiant_win;
private List<Player> players=new ArrayList<Player>();
    private int          skill;
    private int         start_time;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getBarracks_status_dire() {
        return barracks_status_dire;
    }

    public void setBarracks_status_dire(int barracks_status_dire) {
        this.barracks_status_dire = barracks_status_dire;
    }

    public int getBarracks_status_radiant() {
        return barracks_status_radiant;
    }

    public void setBarracks_status_radiant(int barracks_status_radiant) {
        this.barracks_status_radiant = barracks_status_radiant;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public int getDire_score() {
        return dire_score;
    }

    public void setDire_score(int dire_score) {
        this.dire_score = dire_score;
    }

    public int getDire_team_id() {
        return dire_team_id;
    }

    public void setDire_team_id(int dire_team_id) {
        this.dire_team_id = dire_team_id;
    }

    public String getDuration() {


        long hours = duration/ 3600;//转换小时数
        duration = duration% 3600;//剩余秒数
        long minutes = duration/ 60;//转换分钟
        duration= duration % 60;//剩余秒数
            return hours+":"+minutes+":"+duration;


    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public String getFirst_blood_time() {
        long hours = first_blood_time/ 3600;//转换小时数
        first_blood_time = first_blood_time% 3600;//剩余秒数
        long minutes = first_blood_time/ 60;//转换分钟
        first_blood_time= first_blood_time % 60;//剩余秒数
        return hours+":"+minutes+":"+first_blood_time;

    }

    public void setFirst_blood_time(int first_blood_time) {
        this.first_blood_time = first_blood_time;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public void setGame_mode(int game_mode) {
        this.game_mode = game_mode;
    }

    public int getHuman_players() {
        return human_players;
    }

    public void setHuman_players(int human_players) {
        this.human_players = human_players;
    }

    public int getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(int leagueid) {
        this.leagueid = leagueid;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(int lobby_type) {
        this.lobby_type = lobby_type;
    }

    public int getMatch_seq_num() {
        return match_seq_num;
    }

    public void setMatch_seq_num(int match_seq_num) {
        this.match_seq_num = match_seq_num;
    }

    public int getNegative_votes() {
        return negative_votes;
    }

    public void setNegative_votes(int negative_votes) {
        this.negative_votes = negative_votes;
    }

    public int getPositive_votes() {
        return positive_votes;
    }

    public void setPositive_votes(int positive_votes) {
        this.positive_votes = positive_votes;
    }

    public int getRadiant_score() {
        return radiant_score;
    }

    public void setRadiant_score(int radiant_score) {
        this.radiant_score = radiant_score;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getTeamfights() {
        return teamfights;
    }

    public void setTeamfights(int teamfights) {
        this.teamfights = teamfights;
    }

    public int getTower_status_dire() {
        return tower_status_dire;
    }

    public void setTower_status_dire(int tower_status_dire) {
        this.tower_status_dire = tower_status_dire;
    }

    public int getTower_status_radiant() {
        return tower_status_radiant;
    }

    public void setTower_status_radiant(int tower_status_radiant) {
        this.tower_status_radiant = tower_status_radiant;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    private int        teamfights;
    private int         tower_status_dire;
    private int           tower_status_radiant;
    private int          version;
    private int          loss, win;








    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
