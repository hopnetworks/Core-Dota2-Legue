package hopnetworks.dota2.domain;

public class Player {
public Player(){


}

    private int integration=0;
    private int deathsSum=0;
    private int  killsSum=0;
    private String name;
    private int kda;
    private String teamId;
private String accountId;

    public int getIntegration() {
        return integration;
    }

    public void setIntegration(int integration) {
        this.integration = integration;
    }

    public int getDeathsSum() {
        return deathsSum;
    }

    public void setDeathsSum(int deathsSum) {
        this.deathsSum = deathsSum;
    }

    public int getKillsSum() {
        return killsSum;
    }

    public void setKillsSum(int killsSum) {
        this.killsSum = killsSum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKda() {
        return kda;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setKda(int kda) {
        this.kda = kda;
    }


}
