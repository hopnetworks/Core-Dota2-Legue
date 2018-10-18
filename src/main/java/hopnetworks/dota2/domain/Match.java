package hopnetworks.dota2.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Match {
    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
    @Id
    private String matchId;
    private String userName;
    private String passWord;

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
