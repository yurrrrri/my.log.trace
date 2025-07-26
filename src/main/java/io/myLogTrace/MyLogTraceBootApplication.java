package io.myLogTrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "io.myLogTrace.repository")
@SpringBootApplication
@EntityScan("io.myLogTrace.repository.jpa")
public class MyLogTraceBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyLogTraceBootApplication.class, args);
    }
}
