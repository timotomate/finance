package timo.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import timo.finance.domain.Transaction;
import timo.finance.domain.TransactionType;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByAccountId(Long accountId);

    @Query("SELECT t.type, SUM(t.amount) FROM Transaction t " +
            "WHERE t.account.id = :accountId AND t.timestamp BETWEEN :start AND :end " +
            "GROUP BY t.type")
    List<Object[]> getMonthlySummary(@Param("accountId") Long accountId,
                                     @Param("start") LocalDateTime start,
                                     @Param("end") LocalDateTime end);
}
