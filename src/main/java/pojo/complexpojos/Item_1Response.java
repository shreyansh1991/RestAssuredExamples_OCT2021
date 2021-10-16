package pojo.complexpojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item_1Response  extends Item_1Base{


    @JsonProperty("request")
    private RequestResponse request;

    @JsonProperty("request")
    public RequestResponse getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(RequestResponse request) {
        this.request = request;
    }


}
