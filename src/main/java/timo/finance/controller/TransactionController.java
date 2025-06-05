package timo.finance.controller;

import org.springframework.web.bind.annotation.*;
import timo.finance.domain.Transaction;
import timo.finance.domain.TransactionType;
import timo.finance.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction createTransaction(@RequestParam Long accountId,
                                         @RequestParam Long amount,
                                         @RequestParam TransactionType type) {
        return transactionService.createTransaction(accountId, amount, type);
    }
}
