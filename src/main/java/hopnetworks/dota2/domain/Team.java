package hopnetworks.dota2.domain;

import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
public class Team {
   @Id
private ObjectId teamId;

private List<DBObject> playersJson;;
    private String teamName;

    public String getTeamId() {
        return teamId.toString();
    }

    public void setTeamId(ObjectId teamId) {
        this.teamId = teamId;
    }

    public List<DBObject> getPlayersJson() {
        return playersJson;
    }

    public void setPlayersJson(List<DBObject> playersJson) {
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
