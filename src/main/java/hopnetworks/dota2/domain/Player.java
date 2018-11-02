package hopnetworks.dota2.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
public class Player {
    public ObjectId getTeamId() {
        return teamId;
    }

    public void setTeamId(ObjectId teamId) {

        this.teamId = teamId;

    }

    public Player(){


}
    private ObjectId teamId;
    @Id
    private int accountId;
    private int cluster;
    private int palyer_solt;
    private int assists,account_id;
    private int backpack_0;
    private int backpack_1;
    private int backpack_2;
    private int camps_stacked;
    private int creeps_stacked;

    private int gold,kda,gold_per_min;
    private int  hero_damage;
    private int  hero_id;
    private int  iteam_0,iteam_1,iteam_2,iteam_3,iteam_4,iteam_5,kills,level,win,lose;
    private int  xp_per_min;
    private int integration=0;
    private int deathsSum=0;
    private int  killsSum=0;
    private int  matchSum=0;
    private int  assistsSum=0;

    public int getAssistsSum() {
        return assistsSum;
    }

    public void setAssistsSum(int assistsSum) {
        this.assistsSum = assistsSum;
    }

    //private double  per_gold=0;
    private String name="迭名";

private List<Integer> matchIdList=new ArrayList<Integer>();

    public List<Integer> getMatchIdList() {
        return matchIdList;
    }

    public void setMatchIdList(List<Integer> matchIdList) {
        this.matchIdList = matchIdList;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public int getPalyer_solt() {
        return palyer_solt;
    }

    public void setPalyer_solt(int palyer_solt) {
        this.palyer_solt = palyer_solt;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getMatchSum() {
        return matchSum;
    }

    public void setMatchSum(int matchSum) {
        this.matchSum = matchSum;
    }

    public int getBackpack_0() {
        return backpack_0;
    }

    public void setBackpack_0(int backpack_0) {
        this.backpack_0 = backpack_0;
    }

    public int getBackpack_1() {
        return backpack_1;
    }

    public void setBackpack_1(int backpack_1) {
        this.backpack_1 = backpack_1;
    }

    public int getBackpack_2() {
        return backpack_2;
    }

    public void setBackpack_2(int backpack_2) {
        this.backpack_2 = backpack_2;
    }

    public int getCamps_stacked() {
        return camps_stacked;
    }

    public void setCamps_stacked(int camps_stacked) {
        this.camps_stacked = camps_stacked;
    }

    public int getCreeps_stacked() {
        return creeps_stacked;
    }

    public void setCreeps_stacked(int creeps_stacked) {
        this.creeps_stacked = creeps_stacked;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold_per_min() {
        return gold_per_min;
    }

    public void setGold_per_min(int gold_per_min) {
        this.gold_per_min = gold_per_min;
    }

    public int getHero_damage() {
        return hero_damage;
    }

    public void setHero_damage(int hero_damage) {
        this.hero_damage = hero_damage;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public int getIteam_0() {
        return iteam_0;
    }

    public void setIteam_0(int iteam_0) {
        this.iteam_0 = iteam_0;
    }

    public int getIteam_1() {
        return iteam_1;
    }

    public void setIteam_1(int iteam_1) {
        this.iteam_1 = iteam_1;
    }

    public int getIteam_2() {
        return iteam_2;
    }

    public void setIteam_2(int iteam_2) {
        this.iteam_2 = iteam_2;
    }

    public int getIteam_3() {
        return iteam_3;
    }

    public void setIteam_3(int iteam_3) {
        this.iteam_3 = iteam_3;
    }

    public int getIteam_4() {
        return iteam_4;
    }

    public void setIteam_4(int iteam_4) {
        this.iteam_4 = iteam_4;
    }

    public int getIteam_5() {
        return iteam_5;
    }

    public void setIteam_5(int iteam_5) {
        this.iteam_5 = iteam_5;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getXp_per_min() {
        return xp_per_min;
    }

    public void setXp_per_min(int xp_per_min) {
        this.xp_per_min = xp_per_min;
    }



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



    public int getAccountId() {
        return accountId;
    }

 private String personaname="迭名";

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setKda(int kda) {
        this.kda = kda;
    }


}
