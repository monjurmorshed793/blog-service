package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection = "Navigation")
public class Navigation extends ReactivePanacheMongoEntity {
    public String route;
    public String label;
    public String icon;
    public List<Navigation> child = new ArrayList<>();

    @Override
    public String toString() {
        return "Navigation{" +
                "route='" + route + '\'' +
                ", label='" + label + '\'' +
                ", icon='" + icon + '\'' +
                ", child=" + child +
                ", id=" + id +
                '}';
    }
}
