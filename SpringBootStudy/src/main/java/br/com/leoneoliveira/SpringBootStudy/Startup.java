package br.com.leoneoliveira.SpringBootStudy;

import br.com.leoneoliveira.SpringBootStudy.config.FileStorageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageConfig.class
})
@EnableAutoConfiguration
@ComponentScan
public class Startup {

    private static final Logger LOG = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
        LOG.info("App Startup Success ...");
        LOG.info(System.getProperty("user.dir"));
        /*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		String result = bCryptPasswordEncoder.encode("admin123");
		System.out.println("My hash " + result);*/
    }

}
