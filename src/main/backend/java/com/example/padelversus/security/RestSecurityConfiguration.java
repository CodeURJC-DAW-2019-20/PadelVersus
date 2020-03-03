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

        // Matches
        http.authorizeRequests().antMatchers("/api/match/{\\d+}").permitAll();
        http.authorizeRequests().regexMatchers("/api/matches/.*").permitAll();
        http.authorizeRequests().regexMatchers("/api/match/.*").permitAll();

        // Player
        http.authorizeRequests().antMatchers("/api/player/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/api/player/{\\d+}/image").permitAll();
        http.authorizeRequests().antMatchers("/api/player/").permitAll();

        // Team
        http.authorizeRequests().regexMatchers("/api/teamsList/.*").permitAll();
        http.authorizeRequests().antMatchers("/api/teams/").permitAll();
        http.authorizeRequests().antMatchers("/api/teams/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/api/teamx/{\\d+}").permitAll();

        // Tournament
        http.authorizeRequests().antMatchers("/api/tournament/{\\d+}").permitAll();
        http.authorizeRequests().regexMatchers("/api/tournaments/.*").permitAll();
        http.authorizeRequests().antMatchers("/api/tournament/{\\d+}/ranking").permitAll();
        http.authorizeRequests().antMatchers("/api/tournament/").permitAll();

        // User
        http.authorizeRequests().antMatchers("/api/user/login").permitAll();
        http.authorizeRequests().antMatchers("/api/user").permitAll();
        http.authorizeRequests().antMatchers("/api/user/logout").permitAll();

        // Log
        http.authorizeRequests().antMatchers("/api/logIn").permitAll();
        http.authorizeRequests().antMatchers("/api/logOut").permitAll();

        // Private pages (all other pages) (not really needed)
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
