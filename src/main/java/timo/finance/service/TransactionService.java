package timo.finance.service;

import org.springframework.stereotype.Service;
import timo.finance.domain.*;
import timo.finance.repository.AccountRepository;
import timo.finance.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository){
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public Transaction createTransaction(Long accountId, Long amount, TransactionType type) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("계좌를 찾을 수 없습니다. id = " + accountId));
        Transaction transaction = new Transaction(amount, type, account);
        return transactionRepository.save(transaction);
    }

}