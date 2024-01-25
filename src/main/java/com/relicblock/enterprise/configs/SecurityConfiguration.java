package com.relicblock.enterprise.configs;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Disable Cross Site Request Forgery
        http.csrf().disable();

        // Protect endpoints at /api/<type>/secure
        http.authorizeRequests(configurer ->
                        configurer
                                .antMatchers("/api/books/secure/**",
                                        "/api/reviews/secure/**",
                                        "/api/messages/secure/**",
                                        "/api/admin/secure/**")
                                .authenticated())
                .oauth2ResourceServer()
                .jwt();
    }
}
