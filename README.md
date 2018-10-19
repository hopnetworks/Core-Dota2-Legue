
## 技术栈：
Springboot+Mongodb
# dota2-Legue API 接口文档
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

[1、用户信息注册](#1用户信息注册)<br/>
[2、用户登录](#2用户登录)<br/>

## 接口列表：

### 1、用户信息注册

#### 请求URL:  
```
https://ai.hopnetwork.com:8888/regist
```

#### 示例：
 [https://ai.hopnetwork.com:8888/regist](https://ai.hopnetwork.com:8888/regist)

#### 请求方式: 
```
post
```

#### 参数类型：query

|参数|是否必选|类型|说明|
|:-----|:-------:|:-----|:-----|
|UserID      |Y       |string   |用户名|
|password      |Y       |string   |加密后的密码 |

#### 返回示例：

```javascript
{
  status: true,
  user_id: 35,
  user_name: "admin",
}
```

### 2、用户登录

#### 请求URL：
```
https://ai.hopnetwork.com:8888/login

```

#### 示例：
 [https://ai.hopnetwork.com:8888/login](https://ai.hopnetwork.com:8888/login)

#### 请求方式: 
```
GET
```

#### 参数类型：query

|参数|是否必选|类型|说明|
|:-----|:-------:|:-----|:-----|
|UserID      |Y       |string   |用户名|
|password      |Y       |string   |加密后的密码 |
|location      |X       |string   |经度，纬度 |

#### 返回示例：

```javascript
{
  status: true,
  Msg: 35,
  username: "admin",
company_id:"1",
  type: 1 //用户类型
}
```
