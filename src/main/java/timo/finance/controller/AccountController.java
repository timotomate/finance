package timo.finance.controller;

import org.springframework.web.bind.annotation.*;
import timo.finance.domain.Account;
import timo.finance.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(
            @RequestParam String bankName,
            @RequestParam String accountNumber,
            @RequestParam Long userId)
    {
        return accountService.createAccount(bankName, accountNumber, userId);
    }
}
