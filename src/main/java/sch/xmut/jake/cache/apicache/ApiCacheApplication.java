package sch.xmut.jake.cache.apicache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiCacheApplication.class, args);
    }
}
