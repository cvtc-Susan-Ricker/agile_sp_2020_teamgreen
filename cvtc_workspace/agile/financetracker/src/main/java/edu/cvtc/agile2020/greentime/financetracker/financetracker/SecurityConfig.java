package edu.cvtc.agile2020.greentime.financetracker.financetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    // define connection to sql
    @Autowired
    DataSource dataSource;

    @Autowired
    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);

    }


    // define permission to resources
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .defaultSuccessUrl("/index", true)
//                .permitAll();

                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").authenticated()
                .antMatchers("/management/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .successHandler(authenticationSuccessHandler)
                .permitAll();


    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
