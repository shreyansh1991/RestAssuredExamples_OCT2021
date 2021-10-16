package pojo.complexpojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExampleResponse extends ExampleBase{

    @JsonProperty("collection")
    private CollectionResponse collection;

    @JsonProperty("collection")
    public CollectionResponse getCollection() {
        return collection;
    }

    @JsonProperty("collection")
    public void setCollection(CollectionResponse collection) {
        this.collection = collection;
    }


}
