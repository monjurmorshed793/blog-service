package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

@MongoEntity(collection = "Navigation")
public class Navigation extends ReactivePanacheMongoEntity {
    private String id;
    private String route;
    private String name;
    private Navigation[] child;
}
