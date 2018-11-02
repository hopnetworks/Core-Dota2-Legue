

# dota2-Legue API 接口文档
## 技术栈：
Springboot+Mongodb
## 参数说明：
### KEY—比赛（matchId）：

|参数|类型|说明|
|:-----|:-------:|:-----|
|match_id     |      |比赛ID|
|barracks_status_dire      |     |位掩码。表示兵营仍然存在的二进制数的整数。63意味着所有的兵营仍然站在比赛的最后。|
dire_score    |      |夜魇阵营得分|
duration     |      |游戏时间（秒）|
first_blood_time    |      |一血时间|
 tower_status_dire    |      |夜魇塔数|
 tower_status_radiant    |      |天辉塔数|
 radiant_win   |      |天辉是否胜利|
### KEY—选手（player）：
|参数|类型|说明|
|:-----|:-------:|:-----|
|name     |      |名字|
|name     |      |积分|
|mathchIds     |      |所有比赛的ID|
## 目录：

[1、比赛录入](#1比赛录入)<br/>
[2、查询所有选手](#2查询所有选手)<br/>
[3、查询所有比赛数据](#3查询所有比赛数据)<br/>
[4、查询所有队伍数据](#4查询所有队伍数据)<br/>
[5、根据队伍查找选手](#5根据队伍查找选手)<br/>
[6、根据比赛查找选手数据](#6根据比赛查找选手数据)<br/>
[7、增加选手](#7增加选手)<br/>
[9、添加队伍](#9添加队伍)<br/>
## 接口列表：

### 1、比赛录入

#### 请求URL:  
```
https://ai.hopnetwork.com:8000/insertmatch
```

#### 示例：
 [https://ai.hopnetwork.com:8001/insertmatch]

#### 请求方式: 
```
post
```

#### 参数类型：query

|参数|是否必选|类型|说明|
|:-----|:-------:|:-----|:-----|
| matchId     |Y       |int  |比赛名|


#### 返回示例：

```javascript
{
  status: true,//录入成功
}
{
  status: false,//录入失败，有选手不在队伍中
}
```
### 2、查询所有选手

#### 请求URL:  
```
https://ai.hopnetwork.com:8000/insertmatch
```

#### 示例：
 [https://ai.hopnetwork.com:8001/findallplayer]

#### 请求方式: 
```
post
```


#### 返回示例：

```javascript
{
  account_id:''//steam32位ID,
  killSum:0//联赛击杀,
  teamId:0//队伍ID,  
  personname:''//玩家名
  assistSum:0//联赛助攻
  integration:0//联赛积分
}


```
### 3、查询所有比赛数据

#### 请求URL:  
```
https://ai.hopnetwork.com:8001/insertmatch
```

#### 示例：
 [https://ai.hopnetwork.com:8001/insertmatch]

#### 请求方式: 
```
post
```

#### 返回示例：

```javascript
{ barracks_status_dire: 2
  barracks_status_radiant: 63
  cluster: 131
  dire_score: 0
  dire_team_id: 0
  duration: "0:31:49" //持续时间
  engine: 0
  first_blood_time: "0:3:39"
  game_mode: 0
  human_players: 10  //人类玩家
  leagueid: 0
  lobby_type: 0
  lose_team_name: null
  loss: 0
  matchId: 2611524// 比赛ID
  match_seq_num: 2609998
  negative_votes: 0
  passWord: null
  players: Array(10)
  positive_votes: 0
  radiant_score: 0
  radiant_win: true
  skill: 0
  start_time: "1969-12-12 11:13:37"
  teamfights: 0
  tower_status_dire: 0
  tower_status_radiant: 1972
  userName: null
  version: 0
  win: 0  //天辉是否赢
  win_team_name: null
}

```
### 4、查询所有队伍数据

#### 请求URL:  
```
https://ai.hopnetwork.com:8000/findallteam
```

#### 示例：
 [https://ai.hopnetwork.com:8001/findallteam]

#### 请求方式: 
```
post
```

#### 返回示例：

```javascript
{
  gameSum: 0  //比赛数目
  integration: 0 //积分
  playersJson: null 
  teamId: "5bcef99ccbfcce3ac8ebf646"
  teamName: "无名队"
}

```
### 5、根据队伍查找选手

#### 请求URL:  
```
https://ai.hopnetwork.com:8001/findbyteamid
```

#### 示例：
 [https://ai.hopnetwork.com:8001/findbyteamid]

#### 请求方式: 
```
post
```
#### 请求头: 
```
 token:
'Content-Type': 'application/x-www-form-urlencoded'
```

#### 返回示例：

```javascript
{
  account_id:''//steam32位ID,
  killSum:5//联赛击杀,
  teamId:0//队伍ID,  
  personname:''//玩家名
  assistSum:5//联赛助攻
  integration:6//联赛积分
}

```