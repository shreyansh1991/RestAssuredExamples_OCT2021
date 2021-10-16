package pojo.complexpojos;


import java.util.HashMap;
        import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item_1Request extends Item_1Base {


    @JsonProperty("request")
    private RequestRequest request;

    @JsonProperty("request")
    public RequestRequest getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(RequestRequest request) {
        this.request = request;
    }


}
