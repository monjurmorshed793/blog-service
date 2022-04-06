package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import io.smallrye.graphql.api.AdaptToScalar;
import io.smallrye.graphql.api.Scalar;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@MongoEntity(collection = "Division")
public class Division extends ReactivePanacheMongoEntityBase {
    @BsonId
    public String divisionId;
    public String name;
    public String bnName;
    public String url;
}
