package timo.finance.service;

import org.springframework.stereotype.Service;
import timo.finance.domain.*;
import timo.finance.repository.AccountRepository;
import timo.finance.repository.TransactionRepository;
import java.util.List;
import java.time.YearMonth;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository){
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public List<Transaction> getTransactionByAccountId(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }

    public Transaction createTransaction(Long accountId, Long amount, TransactionType type) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("계좌를 찾을 수 없습니다. id = " + accountId));
        Transaction transaction = new Transaction(amount, type, account);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }

    public Map<TransactionType, Long> getMonthlySummary(Long accountId, YearMonth month) {
        LocalDateTime start = month.atDay(1).atStartOfDay();
        LocalDateTime end = month.plusMonths(1).atDay(1).atStartOfDay();

        List<Object[]> result = transactionRepository.getMonthlySummary(accountId, start, end);
        Map<TransactionType, Long> summary = new HashMap<>();
        for (Object[] row : result) {
            TransactionType type = (TransactionType) row[0];
            Long sum = (Long) row[1];
            summary.put(type, sum);
        }
        return summary;
    }
}