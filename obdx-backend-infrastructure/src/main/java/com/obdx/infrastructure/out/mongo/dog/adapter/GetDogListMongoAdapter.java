package com.obdx.infrastructure.out.mongo.dog.adapter;

import com.obdx.domain.commons.entitystatemachine.EntityStateMachine;
import com.obdx.domain.dog.model.Dog;
import com.obdx.domain.dog.port.GetDogListPersistencePort;
import com.obdx.infrastructure.out.mongo.dog.entity.MongoDogEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class GetDogListMongoAdapter implements GetDogListPersistencePort {

    private final MongoTemplate mongoTemplate;

    public GetDogListMongoAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Dog> getDogs(String owner) {

        return mongoTemplate.find(new Query(Criteria.where("owner").is(owner)), MongoDogEntity.class)
                .stream()
                .map(dog -> new Dog(dog.getId(), dog.getName(), dog.getImage(), dog.getOwner(), EntityStateMachine.valueOfState(dog.getState()), dog.getLastUpdate()))
                .collect(Collectors.toList());
    }
}

