package pojo.complexpojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemRequest extends ItemBase{


    @JsonProperty("item")
    private List<Item_1Request> item = null;

    @JsonProperty("item")
    public List<Item_1Request> getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(List<Item_1Request> item) {
        this.item = item;
    }


}

