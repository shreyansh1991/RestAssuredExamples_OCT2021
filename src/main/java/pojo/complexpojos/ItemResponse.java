package pojo.complexpojos;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse extends ItemBase{


    @JsonProperty("item")
    private List<Item_1Response> item = null;

    @JsonProperty("item")
    public List<Item_1Response> getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(List<Item_1Response> item) {
        this.item = item;
    }


}

