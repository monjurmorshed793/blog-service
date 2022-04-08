package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import org.bson.codecs.pojo.annotations.BsonId;

@MongoEntity(collection = "Division")
public class Division extends ReactivePanacheMongoEntityBase {
    @BsonId
    public Integer divisionId;
    public LanguageType name;
    public String url;
}
