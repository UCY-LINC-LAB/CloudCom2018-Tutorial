package cy.ac.ucy.linc.api.config;

import cy.ac.ucy.linc.api.security.CustomUserDetailsService;
import cy.ac.ucy.linc.api.security.JWTAuthenticationEntryPoint;
import cy.ac.ucy.linc.api.security.JWTAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JWTAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter(){
        return new JWTAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Proper configuration
        http.cors().and().csrf()
                .disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/api/v1/all").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/s*").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                ;
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
