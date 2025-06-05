package timo.finance.service;

import org.springframework.stereotype.Service;
import timo.finance.domain.Account;
import timo.finance.domain.User;
import timo.finance.repository.AccountRepository;
import timo.finance.repository.UserRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Account createAccount(String bankName, String accountNumber, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. id = " + userId));
        Account account = new Account(bankName, accountNumber, user);
        return accountRepository.save(account);
    }
}
