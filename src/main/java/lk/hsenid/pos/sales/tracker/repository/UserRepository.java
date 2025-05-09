package lk.hsenid.pos.sales.tracker.repository;

import lk.hsenid.pos.sales.tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
