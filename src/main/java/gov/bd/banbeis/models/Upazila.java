package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import org.bson.codecs.pojo.annotations.BsonId;

@MongoEntity(collection = "Upazila")
public class Upazila extends ReactivePanacheMongoEntityBase {
    @BsonId
    public Integer upazilaId;
    public Integer districtId;
    public LanguageType name;
    public String url;
}
