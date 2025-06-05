package timo.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timo.finance.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}