package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection = "Navigation")
public class Navigation extends ReactivePanacheMongoEntity {
    public Integer sequence;
    public String route;
    public String label;
    public String icon;
    public String roles;
    public List<Navigation> child = new ArrayList<>();

    @Override
    public String toString() {
        return "Navigation{" +
                "sequence=" + sequence +
                ", route='" + route + '\'' +
                ", label='" + label + '\'' +
                ", icon='" + icon + '\'' +
                ", roles='" + roles + '\'' +
                ", child=" + child +
                '}';
    }
}
