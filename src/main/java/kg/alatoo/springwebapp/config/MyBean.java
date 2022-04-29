package kg.alatoo.springwebapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class MyBean {

    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
