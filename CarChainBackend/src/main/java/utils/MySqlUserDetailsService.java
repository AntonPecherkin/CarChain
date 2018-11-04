package utils;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repositories.UsersRepository;

import java.util.Collections;

@Service
public class MySqlUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UsersRepository usersRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try{
            User user = usersRepo.findByUsername(username);
            loadedUser = new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("USER")));
        }catch(Exception repoProblem){
            throw new InternalAuthenticationServiceException(repoProblem.getMessage());
        }

        return loadedUser;
    }
}
