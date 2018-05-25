package com.dogukancelik.kutuphane.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import sun.rmi.transport.proxy.HttpReceiveSocket;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .failureUrl("/login?error=true")
                .and()
                    .logout()
                    .permitAll()
            .and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/kitap-form").hasRole(AuthorizationType.ADMIN.toString())
                    .antMatchers("/yazar-form").hasRole(AuthorizationType.ADMIN.toString())
                    .antMatchers("/yayinevi-form").hasRole(AuthorizationType.ADMIN.toString())
                    .anyRequest().fullyAuthenticated()
            .and().exceptionHandling().accessDeniedPage("/hata/yetkisizerisim");

        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}password").roles(AuthorizationType.ADMIN.toString()).and()
                .withUser("user1").password("{noop}1234").roles(AuthorizationType.USER.toString()).and()
                .withUser("user2").password("{noop}1234").roles(AuthorizationType.USER.toString());
    }
}
