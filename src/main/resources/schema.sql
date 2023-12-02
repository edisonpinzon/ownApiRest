DROP TABLE IF EXISTS LOGAPIREST;
CREATE TABLE LOGAPIREST (
                      log_id INT AUTO_INCREMENT  PRIMARY KEY,
                      log_url_api VARCHAR(50) NOT NULL,
                      time TIMESTAMP NOT NULL
);