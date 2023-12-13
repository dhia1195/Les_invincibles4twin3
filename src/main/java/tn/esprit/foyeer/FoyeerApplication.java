package tn.esprit.foyeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoyeerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoyeerApplication.class, args);
    }

}
