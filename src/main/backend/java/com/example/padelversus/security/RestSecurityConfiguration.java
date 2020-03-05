package com.example.padelversus.security;

import com.example.padelversus.user.UserRepositoryAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

    protected void configure(HttpSecurity http) throws Exception {

        // Public pages //Api
        http.antMatcher("/api/**");


        // Urls that need user role authentication
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/tournament/{\\d+}").hasRole("USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/player/{\\d+}/image").hasRole("USER");

        // Urls that need admin role authentication
        http.authorizeRequests().regexMatchers(HttpMethod.POST, "/api/match/.*").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/match/{\\d+}").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/tournament/").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/tournament").hasRole("ADMIN");

        // Private pages (all other pages) (not really needed)
        http.authorizeRequests().anyRequest().permitAll();

        http.headers().frameOptions().disable();

        // Disable CSRF protection (it is difficult to implement with ng2)
        http.csrf().disable();

        // Use Http Basic Authentication
        http.httpBasic();

        // Do not redirect when logout
        http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //say how many users have
        auth.authenticationProvider(authenticationProvider);
    }
}
