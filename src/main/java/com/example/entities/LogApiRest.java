package com.example.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name="LOGAPIREST")
public class LogApiRest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "log_id")
    @jakarta.persistence.Id
    @GeneratedValue
    Long log_id;

    @Column(name = "log_url_api")
    String log_url_api;

    @Column(name = "time")
    Timestamp time;

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public String getLog_url_api() {
        return log_url_api;
    }

    public void setLog_url_api(String log_url_api) {
        this.log_url_api = log_url_api;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


}
