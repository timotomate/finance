package timo.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timo.finance.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}