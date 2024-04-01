package elearning.elearning.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import elearning.elearning.model.Account;


@Service
public class OurUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepo.findByusername(username).orElseThrow();
    }

    public Account addOurUsers(Account userr){
        return accountRepo.save(userr);
    }
}
