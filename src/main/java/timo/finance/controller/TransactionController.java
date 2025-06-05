package timo.finance.controller;

import org.springframework.web.bind.annotation.*;
import timo.finance.domain.Transaction;
import timo.finance.domain.TransactionType;
import timo.finance.service.TransactionService;
import java.util.List;
import java.time.YearMonth;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam Long accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }

    @PostMapping
    public Transaction createTransaction(@RequestParam Long accountId,
                                         @RequestParam Long amount,
                                         @RequestParam TransactionType type) {
        return transactionService.createTransaction(accountId, amount, type);
    }

    @GetMapping("/summary")
    public Map<TransactionType, Long> getSummary(@RequestParam Long accountId,
                                                 @RequestParam String month) {
        YearMonth ym = YearMonth.parse(month); // "2025-06"
        return transactionService.getMonthlySummary(accountId, ym);
    }

}
