package kakakucom.domain.service;

import kakakucom.domain.model.User;
import kakakucom.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会員登録サービス
 * Created by yutty on 2017/04/10
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser() {
        User user = accountRepository.create(new User(3, "taro", "password", false));
        System.out.println(user + "is created!");
        return user;
    }

}
