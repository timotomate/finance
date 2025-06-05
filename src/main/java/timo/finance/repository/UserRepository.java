package timo.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timo.finance.domain.User;

public interface UserRepository extends JpaRepository <User, Long> {
}
