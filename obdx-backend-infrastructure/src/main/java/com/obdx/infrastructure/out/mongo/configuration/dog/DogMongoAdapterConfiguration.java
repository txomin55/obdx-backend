package com.obdx.infrastructure.out.mongo.configuration.dog;

import com.obdx.domain.dog.port.GetDogListPersistencePort;
import com.obdx.domain.dog.port.GetDogPersistencePort;
import com.obdx.infrastructure.out.mongo.dog.adapter.GetDogListMongoAdapter;
import com.obdx.infrastructure.out.mongo.dog.adapter.GetDogMongoAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ConditionalOnProperty(value = "obdx-backend.deploy.tech", havingValue = "mongo")
public class DogMongoAdapterConfiguration {

    private final MongoTemplate mongoTemplate;

    DogMongoAdapterConfiguration(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    public GetDogListPersistencePort getDogListPersistencePort() {
        return new GetDogListMongoAdapter(mongoTemplate);
    }

    @Bean
    public GetDogPersistencePort getDogPersistencePort() {
        return new GetDogMongoAdapter(mongoTemplate);
    }
}
