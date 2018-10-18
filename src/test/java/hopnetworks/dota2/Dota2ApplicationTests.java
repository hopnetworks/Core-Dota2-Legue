package hopnetworks.dota2;

import hopnetworks.dota2.DAO.MatchRepository;
import hopnetworks.dota2.Utils.HttpRequestUtil;
import hopnetworks.dota2.domain.Match;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Dota2ApplicationTests {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    HttpRequestUtil httpRequestUtil;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
Match match=new Match();
match.setMatchId("match1");
match.setPassWord("155");
match.setUserName("hops");
        logger .info("Mongodb虚拟数据插入测试成功") ;
        matchRepository.save(match);

        String url = "https://api.opendota.com/api/matches/2611455";
        //post请求
        HttpMethod method =HttpMethod.POST;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        //  params.add("access_token", "xxxxx");
        //发送http请求并返回结果
        String s= httpRequestUtil.client(url,method,params);
        logger .info("API获取远程OpenDota2比赛结果测试成功") ;
        System.out.println(s);


    }

}
