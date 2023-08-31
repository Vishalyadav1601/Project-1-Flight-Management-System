package com.palakairlines.flightmanager.Exceptions;



import java.math.BigInteger;


public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    BigInteger fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, BigInteger fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public BigInteger getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(BigInteger fieldValue) {
        this.fieldValue = fieldValue;
    }
}
