package com.ccjr;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/user/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/api/admin/user/login")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.getWriter().write("login success");
                }).failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.getWriter().write("login fail");
                }).and()
                .logout().logoutUrl("/api/admin/user/logout")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.getWriter().write("logout success");
                })
                .and().exceptionHandling().authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.getWriter().write("no login");
                });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //release swagger2
        web.ignoring().antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }
}
