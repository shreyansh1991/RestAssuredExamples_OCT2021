package pojo.complexpojos;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionBase {

    @JsonProperty("info")
    private InfoBase info;

    @JsonProperty("info")
    public InfoBase getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(InfoBase info) {
        this.info = info;
    }
}
