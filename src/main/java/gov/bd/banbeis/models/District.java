package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import org.bson.codecs.pojo.annotations.BsonId;

@MongoEntity(collection = "District")
public class District extends ReactivePanacheMongoEntityBase {
    public Integer divisionId;
    public Integer districtId;
    public LanguageType name;
    public String lat;
    public String lon;
    public String url;
}
