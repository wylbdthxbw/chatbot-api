package cn.bugstack.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    @Test
    public void base64(){
        String cronExpression = new String(Base64.getDecoder().decode("MC81MCAqICogKiAqID8="), StandardCharsets.UTF_8);
        System.out.println(cronExpression);
    }

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48411118851818/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "知识星球个人cookie信息");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void query_answered_questions_tieba() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://sofire.baidu.com/abot/api/v1/tpl/commit");
        post.addHeader("cookie", "BAIDUID=0DA923E243F052DD633E74336571538B:FG=1; BAIDUID_BFESS=0DA923E243F052DD633E74336571538B:FG=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2219036060565a67-02c23bbc61c2dc-26001f51-3686400-190360605661311%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.google.com%2F%22%7D%2C%22%24device_id%22%3A%2219036060565a67-02c23bbc61c2dc-26001f51-3686400-190360605661311%22%7D; BIDUPSID=0DA923E243F052DD633E74336571538B; PSTM=1720329747; BAIDU_WISE_UID=wapp_1720616240834_574; BDUSS=XFDWER3Y0x1c1ZCT1gtWjBMLXE2amFqfkZtdWFueVNuUkxUM1R3R2c5WnB1cmhtSVFBQUFBJCQAAAAAAAAAAAEAAAAYBvfnenNneGhhAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGktkWZpLZFmb; BDUSS_BFESS=XFDWER3Y0x1c1ZCT1gtWjBMLXE2amFqfkZtdWFueVNuUkxUM1R3R2c5WnB1cmhtSVFBQUFBJCQAAAAAAAAAAAEAAAAYBvfnenNneGhhAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGktkWZpLZFmb; __bid_n=190ee877c1d460813342b5; H_PS_PSSID=60236_60453_60469_60492_60502_60517; MCITY=-132%3A; arialoadData=false; ZFY=OGloAtdjhS9YYFDBWs7G9BR3sO:AsScGh5osVUbqXX64:C; BA_HECTOR=21ak808l812g2h8ha10h8gah3sg8s71jaf8hc1v; ab_sr=1.0.1_YTg1YjJlNjBhYTE2MTBjY2RiNDAzNmQzNjE0OWFjM2Q5ZjdmOTc1MjMzYWQ2MWIwM2Q2MGE2YWJhMDg0NzU1NjgyODM3ZmZjMGRkNTEzNzNjYzQ2MGU3MTNjZDYyYTExZTE1MWUyMTk4ZmY0NTA2Mzg5ZGU4OWFiM2UyNzQxNzQxNzIyYzNlMGE4NTNkNjFlYTRjMWM3ZDAyNTNjNGY5ZmQ2N2Y1MDg5NGM1MGY3YmEyMzFjMDQ2ZWY4NDFjYzk1; RT=\"z=1&dm=baidu.com&si=78dd58c4-3efc-4e9b-b34c-a1ad6cd94f29&ss=lz7238kz&sl=17&tt=u1l&bcn=https%3A%2F%2Ffclog.baidu.com%2Flog%2Fweirwood%3Ftype%3Dperf&ld=f9lz&nu=35c94jwp&cl=fdxa\"");
        post.addHeader("Content-Type", "text/plain");
        String paramJson = "12345";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412884248251548/answer");
        post.addHeader("cookie", "知识星球个人cookie信息");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 自行申请 https://beta.openai.com/overview");

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
