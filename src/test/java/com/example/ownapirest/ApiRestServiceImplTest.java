package com.example.ownapirest;

import com.example.entities.LogApiRest;
import com.example.repository.LogApiRestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.sql.Timestamp;
import java.util.Calendar;


@DataJpaTest
class ApiRestServiceImplTest {

    @Autowired
    LogApiRestRepository repository;

    @Test
    public void createLog(){
        LogApiRest log = new LogApiRest();
        log.setLog_url_api("test Junit");
        log.setTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        repository.save(log);

    }
             
}