package hopnetworks.dota2.Controller;

import hopnetworks.dota2.DAO.MatchRepository;
import hopnetworks.dota2.Utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
@Autor zhuoyj[hopnetworks]
@Date 2018/10/18
@function 比赛记录的API控制器
@Description

*/
public class MatchController {
@Autowired
    private MatchRepository matchRepository;
@Autowired
    HttpRequestUtil httpRequestUtil;


@RequestMapping(value = "/insertmatch")
@ResponseBody
    public boolean inserMatvh(String matchId){

    String url = "https://api.opendota.com/api/matches/2611455";
    //post请求
    HttpMethod method =HttpMethod.POST;
    // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
    MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
  //  params.add("access_token", "xxxxx");
    //发送http请求并返回结果
  String s= httpRequestUtil.client(url,method,params);

  System.out.println(s);
  return  true ;
}







}
