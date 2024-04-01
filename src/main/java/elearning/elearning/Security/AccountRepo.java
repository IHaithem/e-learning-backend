package elearning.elearning.Security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import elearning.elearning.model.Account;

public interface AccountRepo extends JpaRepository<Account,Long>{

    Optional<Account> findByusername(String username);

} 
