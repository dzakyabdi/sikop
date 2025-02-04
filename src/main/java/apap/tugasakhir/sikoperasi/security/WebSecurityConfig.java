package apap.tugasakhir.sikoperasi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/home").hasAuthority("Pengurus Koperasi")
                .antMatchers("/anggota/viewall").hasAuthority("Pengurus Koperasi")
                .antMatchers("/anggota/ubah-status**").hasAuthority("Pengurus Koperasi")
                .antMatchers("/pinjaman/").hasAnyAuthority("Pengurus Koperasi", "Anggota Koperasi")
                .antMatchers("/ruangan/peminjaman").hasAuthority("Pengurus Koperasi")
                .antMatchers("/pinjaman/ubah/**").hasAuthority("Pengurus Koperasi")
                .antMatchers("/simpanan/tambah").hasAuthority("Pengurus Koperasi")
                .antMatchers("/pinjaman/ajukan").hasAnyAuthority("Pengurus Koperasi", "Anggota Koperasi")
                .antMatchers("/laporan-keuangan").hasAnyAuthority("Pengurus Koperasi", "Anggota Koperasi")
                .antMatchers("/peminjaman").hasAuthority("Pengurus Koperasi")
                .antMatchers("/api/").permitAll()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll()
                .and().csrf().disable();
    }


    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("admin").password(encoder().encode("admin123"))
//                .roles("Pengurus Koperasi");
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }


}
