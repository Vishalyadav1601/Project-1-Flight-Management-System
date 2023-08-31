package com.palakairlines.flightmanager.DTO;

public class ApiResponse {

    private String Message;
    private Boolean Success;

    public ApiResponse() {
    }

    public ApiResponse(String message, Boolean success) {
        Message = message;
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }
}
