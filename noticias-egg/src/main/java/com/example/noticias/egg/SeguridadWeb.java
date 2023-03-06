
package com.example.noticias.egg;

import com.example.noticias.egg.servicios.UsuarioServicio;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter{
    
    @Autowired
    public UsuarioServicio usuarioServicio;   
    
    @Autowired
    public void configureGlonal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(usuarioServicio)   //Con este método autentica el usuario
        .passwordEncoder(new BCryptPasswordEncoder());                   //Una vez autenticado pasamos la contraseña ENCRIPTADA con este método
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                  .antMatchers("/admin/*").hasRole("ADMIN")                //De esta manera los únicos que pueden ingresar al panel de admin tienen que tener rol admin
                  .antMatchers("/css/*","/js/*" , "/img/*","/**")
                  .permitAll()
                .and().formLogin()
                   .loginPage("/login")                         //url donde se encuentra el formulario de login
                   .loginProcessingUrl("/logincheck")      //url donde springsecurity va a autenticar un usuario, el logincheck debe coincidir con el TH:ACTION de logeo del html que es el que envia este dato
                   .usernameParameter("nombreUsuario")     //se configuran las credenciales
                   .passwordParameter("password")         
                   .defaultSuccessUrl("/inicio")           //si todo sale bien a que url lo mando
                   .permitAll()
                .and().logout()
                   .logoutUrl("/logout")        //url donde se va al cierre
                   .logoutSuccessUrl("/login")      //A donde se dirige si todo cierra bien
                   .permitAll()  //permitimnos todo lo que confirmamos. 
                .and().csrf()
                    .disable();
                
                
     }            
                
} 
