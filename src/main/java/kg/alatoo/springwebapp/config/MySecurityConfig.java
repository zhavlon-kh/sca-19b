package kg.alatoo.springwebapp.config;

import ch.qos.logback.core.joran.action.IADataForComplexProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.Function;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            UserDetails admin = User.builder()
                    .username("admin")
                    .password("admin")
                    .roles("ADMIN")
                    .passwordEncoder(password -> password)
                    .build();

            UserDetails user = User.builder()
                    .username("user")
                    .password("user")
                    .roles("USER")
                    .passwordEncoder(password -> password)
                    .build();

            return username.equalsIgnoreCase("admin")?admin:user;
        };
    }
}
