package com.example.padelversus.security;

import com.example.padelversus.user.UserRepositoryAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
        http.authorizeRequests().antMatchers("/api/tournament/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/api/tournaments/").permitAll();
        http.authorizeRequests().regexMatchers("/api/tournaments/.*").permitAll();
        http.authorizeRequests().regexMatchers("/api/tournament/.*").permitAll();

        http.authorizeRequests().regexMatchers("/api/match/.*").permitAll();

        http.authorizeRequests().antMatchers("/api/player/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/api/player/{\\d+}/image").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/api/teamx/{\\d+}").permitAll();
        http.authorizeRequests().regexMatchers("/api/teams/.*").permitAll();
        http.authorizeRequests().antMatchers("/api/teams/.*").permitAll();
        http.authorizeRequests().antMatchers("/api/match/{\\d+}").permitAll();
        http.authorizeRequests().regexMatchers("/api/matches/.*").permitAll();
        http.authorizeRequests().regexMatchers("/api/teamsList/.*").permitAll();
        http.authorizeRequests().regexMatchers("/api/logIn").permitAll();
        http.authorizeRequests().regexMatchers("/api/user").hasAnyRole("ADMIN");
        http.authorizeRequests().regexMatchers("/api/player").hasAnyRole("ADMIN");
        http.authorizeRequests().regexMatchers("/api/tournament/").hasAnyRole("ADMIN");



        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().authenticated();

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
