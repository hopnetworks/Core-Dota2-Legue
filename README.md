

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

### KEY—选手（player）：
|参数|类型|说明|
|:-----|:-------:|:-----|
|name     |      |名字|
|name     |      |积分|
|mathchIds     |      |所有比赛的ID|
## 目录：

[1、比赛录入](#1比赛录入)<br/>


## 接口列表：

### 1、比赛录入

#### 请求URL:  
```
https://ai.hopnetwork.com:8000/insertmatch
```

#### 示例：
 [https://ai.hopnetwork.com:8000/insertmatch](https://ai.hopnetwork.com:8000/insertmatch)

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

