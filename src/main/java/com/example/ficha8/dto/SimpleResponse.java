package com.example.ficha8.dto;

public class SimpleResponse {
    private boolean status;
    private String message;

    public SimpleResponse() {
        // redundante: primitiva começa no valor +baixo (false = 0)
        this.status = false;
        this.message = "Ocorreu um erro";
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
