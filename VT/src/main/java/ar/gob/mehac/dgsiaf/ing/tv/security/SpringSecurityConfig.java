package ar.gob.mehac.dgsiaf.ing.tv.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AccessDeniedHandler accessDeniedHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers("/", "/home", "/about", "/webjars").permitAll()
        .antMatchers("/admin/**", "/addRSS").hasAnyRole("ADMIN").antMatchers("/user/**").hasAnyRole("USER")
        // .anyRequest().authenticated()
        .and().formLogin().loginPage("/login")
        // .permitAll().and().logout().permitAll()
        .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")
        .password(passwordEncoder.encode("password")).roles("USER").and().withUser("admin")
        .password(passwordEncoder.encode("password")).roles("ADMIN");
  }
}