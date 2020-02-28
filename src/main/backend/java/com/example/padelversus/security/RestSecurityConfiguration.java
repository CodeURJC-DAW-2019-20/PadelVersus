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

        // Public pages
        // Web
        /*http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/match/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/matches/").permitAll();
        http.authorizeRequests().antMatchers("/teams/").permitAll();
        http.authorizeRequests().antMatchers("/teamx/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/player/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/tournament/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/signup").permitAll();
        http.authorizeRequests().antMatchers("/apiTeams/").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/saveUser").permitAll();
        http.authorizeRequests().antMatchers("/signupPlayer").permitAll();
        http.authorizeRequests().antMatchers("/saveMatch").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/adminPage").hasAnyRole("ADMIN"); //Only admin
        http.authorizeRequests().antMatchers("/uploadImage").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/images_temp/**").permitAll();
        http.authorizeRequests().antMatchers("/pdf_temp/**").permitAll();
        http.authorizeRequests().antMatchers("/tournament/pdf**").permitAll();*/

        //Api
        http.antMatcher("/api/**");
        http.authorizeRequests().antMatchers("/api/tournament/{\\d+}").permitAll();
        http.authorizeRequests().antMatchers("/api/tournaments/").permitAll();
        http.authorizeRequests().regexMatchers("/api/tournament/.*").permitAll();
        http.authorizeRequests().regexMatchers("/api/match/.*").permitAll();

        //Resources
        //http.authorizeRequests().antMatchers("/css-min/**", "/css/main.css", "/css/**", "/js/**", "/images/**", "/fonts/**", "/dev-assets/**", "/vendor/**", "/html/**").permitAll();

        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/api/logIn");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/api/logOut");
        http.logout().logoutSuccessUrl("/");

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
