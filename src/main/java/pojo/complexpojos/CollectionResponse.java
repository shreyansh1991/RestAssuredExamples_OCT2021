package pojo.complexpojos;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionResponse extends CollectionBase{


    @JsonProperty("item")
    private List<ItemResponse> item = null;


    @JsonProperty("item")
    public List<ItemResponse> getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(List<ItemResponse> item) {
        this.item = item;
    }


}
