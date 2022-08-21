package com.coder.platzimarket.domain.service;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoderUserDatailsService  implements UserDetailsService {



    @Override
    public static UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("Katlawwliet", "{noop}coder", new ArrayList<>());
    }

}


