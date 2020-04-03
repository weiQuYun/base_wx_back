package com.wqy.wx.back.configer;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * 成都微趣云网络科技有限公司
 *
 * @ClassName: MongodbBaseConfig
 * @Description: TODO
 * @Author licm
 * @Date 2019/12/5 9:08
 * @Version V1.0
 * @Explain :
 **/
@Configuration
public class MongodbBaseConfig {
    public static final String mongoPropertiesBase = "mongoPropertiesBase";
    public static final String mongoClientBase = "mongoClientBase";
    public static final String mongoDbFactoryBase = "mongoDbFactoryBase";
    public static final String mongoTemplateBase = "mongoTemplate";

    @Bean(name = mongoPropertiesBase)
    @ConfigurationProperties(prefix = "mongodb.base")
    @Primary
    public MongoProperties setMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name = mongoClientBase)
    @Primary
    public MongoClient setMongoClient(@Qualifier(mongoPropertiesBase) MongoProperties mongoProperties) {
        // MongoDB地址
        ServerAddress serverAddress = new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort());

        // 连接认证（用户名，数据库，密码 ）
        MongoCredential mongoCredential = MongoCredential.createCredential(mongoProperties.getUsername(),
                mongoProperties.getDatabase(), mongoProperties.getPassword());

        // 连接选项
        MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().build();

        // new MongoClientOptions.Builder()
        // .connectTimeout(Integer.parseInt(connectTimeout)) // 链接超时时间
        // .socketTimeout(Integer.parseInt(socketTimeout)) // read数据超时时间
        // .readPreference(ReadPreference.secondary()) // 最近优先策略
        // //.autoConnectRetry(false) // 是否重试机制
        // .connectionsPerHost(Integer.parseInt(perHost)) // 每个地址最大请求数
        // .maxWaitTime(Integer.parseInt(waitTime)) // 长链接的最大等待时间
        // .threadsAllowedToBlockForConnectionMultiplier(Integer.parseInt(connectionMultiplier)).build();
        // // 一个socket最大的等待请求数
        // //.writeConcern(WriteConcern.NORMAL).build();

        return new MongoClient(serverAddress, mongoCredential, mongoClientOptions);
    }

    @Bean(name = mongoDbFactoryBase)
    @Primary
    public MongoDbFactory setMongoDbFactory(@Qualifier(mongoClientBase) MongoClient mongoClient,
                                            @Qualifier(mongoPropertiesBase) MongoProperties mongoProperties) throws Exception {

        return new SimpleMongoDbFactory(mongoClient, mongoProperties.getDatabase());
    }

    @Primary
    @Bean(name = mongoTemplateBase)
    public MongoTemplate setMongoTemplate(@Qualifier(mongoDbFactoryBase) MongoDbFactory mongoDbFactory)
            throws Exception {
        return new MongoTemplate(mongoDbFactory);
    }
//    @Primary
//    @Bean
//    public BaseMongoModel setMongoBaseDao(@Qualifier(mongoTemplateBase) MongoTemplate mongoTemplate)
//            throws Exception {
//        return new BaseMongoModel(mongoTemplate);
//    }
}
