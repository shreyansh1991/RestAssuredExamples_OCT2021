package pojo.complexpojos;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionRequest extends CollectionBase{


    @JsonProperty("item")
    private List<ItemRequest> item = null;

    @JsonProperty("item")
    public List<ItemRequest> getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(List<ItemRequest> item) {
        this.item = item;
    }


}
