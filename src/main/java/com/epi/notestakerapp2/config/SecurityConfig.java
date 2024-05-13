package com.epi.notestakerapp2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //enables Spring Security for web applications.
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);//pour prendre les details du user
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); //hash the code
        return daoAuthenticationProvider;
    }
    /*
    DaoAuthenticationProvider is a class that implements the AuthenticationProvider interface.
    prend les user details +comparaison des mots de passe+decision d'authentification:si mdps match alors on eut faire login
    * */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //HttpSecurity c pour securiser les https requests



        //CSRF is a type of attack : on le desactive
        //requestMatchers("/user/**").hasRole("USER"): seuls les urls ui commencent par user et ont role user peuvent acceder

        http.csrf().disable().authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/**").permitAll().and() //url du login page
                .formLogin().loginPage("/signin")
                .loginProcessingUrl("/userLogin")//ouvre le form du sign in
                .defaultSuccessUrl("/user/addNotes").permitAll(); //default url after successful login
        return http.build();

    }
}