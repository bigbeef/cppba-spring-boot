package com.cppba.base.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.*;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class BaseBean implements Serializable {

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public boolean equals(Object o, String... excludeFields) {
        return EqualsBuilder.reflectionEquals(this, o, excludeFields);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public int compareTo(Object o) {
        return CompareToBuilder.reflectionCompare(this, o);
    }

    public int compareTo(Object o, String... excludeFields) {
        return CompareToBuilder.reflectionCompare(this, o, excludeFields);
    }

    public String toJSONString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
