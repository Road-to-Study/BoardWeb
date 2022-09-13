//package board.boardspring.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//
//public class security extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                     .antMatchers("/","/list","/login","/register","/view","/modify","/write").permitAll()
//                     .anyRequest().authenticated()
//                     .and()
//                .formLogin()
//                     .loginPage("/login")
//                     .permitAll()
//                     .and()
//                .logout()
//                     .permitAll();
//    }
//
//
//
//}
