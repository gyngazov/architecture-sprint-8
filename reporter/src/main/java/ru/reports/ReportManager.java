package ru.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories
//@EnableTransactionManagement
public class ReportManager {
    public static void main(String[] args) {
        SpringApplication.run(ReportManager.class, args);
    }
}