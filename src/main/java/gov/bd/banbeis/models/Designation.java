package gov.bd.banbeis.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.smallrye.graphql.api.AdaptToScalar;
import io.smallrye.graphql.api.Scalar;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MongoEntity(collection = "Designation")
public class Designation extends ReactivePanacheMongoEntity {

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


    @Override
    public String toString() {
        return "Designation{" +
                "name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", grade=" + grade +
                ", bn=" + bn +
                '}';
    }
}
