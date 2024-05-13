package com.epi.notestakerapp2.config;

import com.epi.notestakerapp2.entity.User;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements UserDetails {/*Dans Spring Security,
 UserDetails est  une interface prédéfinie.
 fournit un moyen standard de représenter un utilisateur à des fins d'authentification.*/

    /*CustomUser implémente toutes les méthodes requises par l'interface UserDetails.
     Ces méthodes permettent à Spring Security d'accéder aux informations de l'utilisateur pour l'authentification et la gestion des accès :*/

    private User user;

    public CustomUser(User user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
    getAuthorities Retourne une collection d'autorités (rôles) de l'utilisateur.
    */

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());//on crée une seule autorité basée sur le rôle

        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
        //Retourne le mot de passe de l'utilisateur stocké dans l'objet User.
    }

    @Override
    public String getUsername() {
        return user.getEmail();//Retourne le nom d'utilisateur de l'utilisateur. Ici, on utilise l'adresse email ( user.getEmail() ) stockée dans l'objet User.
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /*
    isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled() :
    Ces méthodes renvoient toutes true par défaut dans cet exemple,
    indiquant que le compte de l'utilisateur n'est pas expiré, verrouillé ou désactivé
    * */

}
