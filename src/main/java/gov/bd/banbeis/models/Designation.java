package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import io.smallrye.graphql.api.AdaptToScalar;
import io.smallrye.graphql.api.Scalar;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Ignore;
import org.eclipse.microprofile.graphql.Input;
import org.eclipse.microprofile.graphql.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MongoEntity(collection = "Designation")
public class Designation extends ReactivePanacheMongoEntityBase {

    @AdaptToScalar(Scalar.String.class)
    public ObjectId id;

    @NotBlank(message = "Name must not be blank")
    public String name;
    @NotBlank(message = "Short name must not be blank")
    public String shortName;
    @NotBlank(message = "Grade must not be blank")
    public Integer grade;
    @NotNull(message = "Must provide Bangla section")
    public Designation bn;
}
