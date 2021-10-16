package pojo.complexpojos;


import java.util.HashMap;
        import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExampleRequest extends ExampleBase{

    @JsonProperty("collection")
    private CollectionRequest collection;

    @JsonProperty("collection")
    public CollectionRequest getCollection() {
        return collection;
    }

    @JsonProperty("collection")
    public void setCollection(CollectionRequest collection) {
        this.collection = collection;
    }


}
