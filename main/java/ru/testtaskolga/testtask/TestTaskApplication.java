package ru.testtaskolga.testtask;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableCaching
@SpringBootApplication
@EnableScheduling
public class TestTaskApplication {

    @CacheEvict(allEntries = true, value = "regionCache")
    @Scheduled(fixedDelay = 15000)
    public void cacheEvict() {
        System.out.println("cache evict");
    }

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }


}