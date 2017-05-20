package kakakucom.service;

import kakakucom.component.exception.ExceptionProvider;
import kakakucom.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ExceptionProvider exceptionProvider;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return Optional.ofNullable(accountRepository.findOne(email))
            .map(AccountDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException(
                "user specified by " + email + " is not found!"
            ));
    }
}
