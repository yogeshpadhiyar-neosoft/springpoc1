package com.neosoft.springPOC1.requestpojo;

import com.neosoft.springPOC1.model.UserMaster;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
public class Login implements UserDetails {
    private String emailId;
    private String password;
    private boolean active;

    public Login(UserMaster userMaster){
        this.emailId = userMaster.getUserDetail().getEmailId();
        this.password = userMaster.getPassword();
        this.active = userMaster.getActive();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return emailId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
