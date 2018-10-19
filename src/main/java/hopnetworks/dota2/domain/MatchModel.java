package hopnetworks.dota2.domain;

import com.mongodb.DBObject;
import org.springframework.data.annotation.Id;

public class MatchModel {


    @Id
    private String matchId;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public DBObject getMatchJson() {
        return matchJson;
    }

    public void setMatchJson(DBObject matchJson) {
        this.matchJson = matchJson;
    }

    private DBObject matchJson;

}
