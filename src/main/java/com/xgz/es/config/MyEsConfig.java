package com.xgz.es.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyEsConfig {


    /**
     * 高级Rest客户端被弃用，取而代之的是Elasticsearch Java API客户端
     *在Es7.15版本之后，es官方将它的高级客户端RestHighLevelClient标记为弃用状态。
     * 同时推出了全新的java API客户端Elasticsearch Java API Client，
     * 该客户端也将在Elasticsearch8.0及以后版本中成为官方推荐使用的客户端。
     *
     */






    /**
     * Elasticsearch官方列出了好几个客户端，如下所示
     *
     * Java Client
     * Java Rest Client（Java High Level REST Client）
     * Java Transport Client
     * 其中Java Rest Client在7.15.0被标记已过时，Java Transport Client暂时没找到在哪个版本被标记过时
     */

//    @Bean
//public RestHighLevelClient restHighLevelClient(){
//        return new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200,"http")));
//    }


    /**
     *  java 客户端方式
     *
     *  参考  https://juejin.cn/post/7341302235016134692
     *
     * @return
     */
    @Bean
    public ElasticsearchClient elasticsearchClient(){
        RestClientBuilder builder = RestClient.builder(new HttpHost("127.0.0.1", 9200));
        RestClientTransport transport = new RestClientTransport(builder.build(), new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }




}
