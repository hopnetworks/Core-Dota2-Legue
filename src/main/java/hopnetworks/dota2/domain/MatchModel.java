package hopnetworks.dota2.domain;

import com.mongodb.DBObject;
import org.springframework.data.annotation.Id;

public class MatchModel {


    @Id
    private int matchId;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
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
