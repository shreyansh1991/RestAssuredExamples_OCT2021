package pojo.complexpojos;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBase {


    @JsonProperty("method")
    private String method;
    @JsonProperty("header")
    private List<HeaderBase> header = null;
    @JsonProperty("body")
    private BodyBase body;
    @JsonProperty("description")
    private String description;

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("header")
    public List<HeaderBase> getHeader() {
        return header;
    }

    @JsonProperty("header")
    public void setHeader(List<HeaderBase> header) {
        this.header = header;
    }

    @JsonProperty("body")
    public BodyBase getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(BodyBase body) {
        this.body = body;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

}
