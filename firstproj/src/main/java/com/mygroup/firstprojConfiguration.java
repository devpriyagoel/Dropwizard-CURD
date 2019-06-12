package com.mygroup;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class firstprojConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String defaultAlias = "Default";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

//    @JsonProperty
//    public void setTemplate(String template) {
//        this.template = template;
//    }


    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

//    @JsonProperty
//    public void setDefaultName(String name) {
//        this.defaultName = name;
//    }

    @JsonProperty
    public String getDefaultAlias() {
        return defaultAlias;
    }

//    @JsonProperty
////    public void setDefaultAlias(String alias) {
////        this.defaultAlias = alias
////    }

}
