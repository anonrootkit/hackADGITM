package com.hackathon.adgitm.model;

import com.google.gson.annotations.SerializedName;

public class Auth {
    @SerializedName("status")
    Integer status;
    @SerializedName("id")
    Integer id;
    @SerializedName("err")
    String err;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
