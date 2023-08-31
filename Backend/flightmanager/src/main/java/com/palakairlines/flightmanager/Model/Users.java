package com.palakairlines.flightmanager.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users implements Serializable, UserDetails {

    @Id
    @GeneratedValue(generator = "SixDigitIdGenerator")
    @GenericGenerator(name = "SixDigitIdGenerator", strategy = "com.palakairlines.flightmanager.CustomGenerator.SixDigitIdGenerator")
    @Column(length = 6)
    private BigInteger userId;
    @Column(name = "userName")
    private String userName;
    private String userPassword;

    private BigInteger userPhone;

    private String userEmail;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ScheduleFlight> scheduleFlights = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = this.roles.stream().map((roles)->new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
}

