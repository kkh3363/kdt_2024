package com.kdt.myjpa.config;

import com.kdt.myjpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig //extends WebSecurityConfigurerAdapter
 {
     @Autowired
     MemberService memberService;

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.formLogin()
                 .loginPage("/members/login")
                 .defaultSuccessUrl("/")
                 .usernameParameter("email")
                 .failureUrl("/members/login/error")
                 .and()
                 .logout()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                 .logoutSuccessUrl("/");

        http.authorizeHttpRequests(request -> request
                         .requestMatchers("/", "/members/**", "/item/**", "/images/**","/css/**").permitAll()
                         .requestMatchers("/admin/*").hasRole("ADMIN")
                         .anyRequest().authenticated()
                 )
                 .httpBasic(withDefaults());
         return http.build();
     }

     @Bean
     public PasswordEncoder PasswordEncoder () {
         //return new MessageDigestPasswordEncoder("SHA-256");
         return new BCryptPasswordEncoder();
     }
}
