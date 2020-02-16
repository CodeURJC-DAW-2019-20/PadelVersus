package com.example.padelversus.security;

import com.example.padelversus.user.UserRepositoryAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;
    protected void configure(HttpSecurity http) throws Exception{

        // Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/matches").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/signup").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/saveUser").permitAll();
        http.authorizeRequests().antMatchers("/signupPlayer").permitAll();
        http.authorizeRequests().antMatchers("/uploadImage").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/h2-console/**").hasAnyRole("ADMIN");
        //http.authorizeRequests().antMatchers("../static/css/library/**").permitAll();
        http.authorizeRequests().antMatchers("/css-min/**","/css/main.css","/css/**","/js/**","/images/**","/fonts/**","/dev-assets/**","/vendor/**").permitAll();
        //http.authorizeRequests().antMatchers("/resources/**").permitAll();
        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

        // Disable CSRF at the moment
        http.csrf().disable();
        http.headers().frameOptions().disable();
        /*http
                .authorizeRequests()
                .antMatchers( "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //Decimos cuantos usuarios tiene
        auth.authenticationProvider(authenticationProvider);
    }
}
