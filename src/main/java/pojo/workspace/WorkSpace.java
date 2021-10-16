package pojo.workspace;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


// deserializaiton --> allowSetters
// serialization --> allowGetters

@JsonIgnoreProperties(value ="id",allowSetters = true)
public class WorkSpace {
    private String name;
    private String type;
    private String description;
    private String id;

   public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public WorkSpace setName(String name) {
        this.name = name;
        return this;
    }

    public WorkSpace setType(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return type;
    }

    public WorkSpace setDescription(String description) {
        this.description = description;
        return this;
    }



}
