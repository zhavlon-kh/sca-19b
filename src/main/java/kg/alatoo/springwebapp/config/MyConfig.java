package kg.alatoo.springwebapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean("myFirstBean");
    }

    @Bean("secondBean")
    public MyBean myBean(@Value("${beans.myBean.name}") String name) {
        return new MyBean(name);
    }

}
