package hopnetworks.dota2.domain;

import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Team {
   @Id
private ObjectId teamId;

private DBObject playersJson;;
    private String teamName;

    public ObjectId getTeamId() {
        return teamId;
    }

    public void setTeamId(ObjectId teamId) {
        this.teamId = teamId;
    }

    public DBObject getPlayersJson() {
        return playersJson;
    }

    public void setPlayersJson(DBObject playersJson) {
        this.playersJson = playersJson;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getIntegration() {
        return integration;
    }

    public void setIntegration(int integration) {
        this.integration = integration;
    }

    private int integration=0;

    public int getGameSum() {
        return gameSum;
    }

    public void setGameSum(int gameSum) {
        this.gameSum = gameSum;
    }

    private int gameSum=0;
}
