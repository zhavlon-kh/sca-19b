package kg.alatoo.springwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/authors")
                        .authenticated()
                    .antMatchers("/admin")
                        .hasRole("ADMIN")
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/process-login")
                .usernameParameter("user-login")
                .passwordParameter("password")
                    .permitAll().and()
                .logout().permitAll();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .passwordEncoder(passwordEncoder()::encode)
                .build();
        System.out.println("user.getPassword() = " + user.getPassword());
        return new InMemoryUserDetailsManager(user
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
