package com.doksakura.model;

import com.google.gson.Gson;

public class RespondMessage {

    private RespondStatus status;
    private String reason = "";

    public RespondMessage(RespondStatus status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return status.name() + " : " + reason;
    }
}