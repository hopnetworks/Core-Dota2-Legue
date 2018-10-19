package hopnetworks.dota2.domain;

import com.mongodb.DBObject;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Team {
   @Id
private String teamId;

private DBObject playersJson;;
    private String teamName;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
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

    private int integration;
}
