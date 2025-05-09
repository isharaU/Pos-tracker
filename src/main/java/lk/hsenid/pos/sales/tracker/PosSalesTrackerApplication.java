package lk.hsenid.pos.sales.tracker;

import lk.hsenid.pos.sales.tracker.entity.User;
import lk.hsenid.pos.sales.tracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PosSalesTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosSalesTrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(new User(null, "cashier1", encoder.encode("pass"), User.Role.CASHIER));
                userRepository.save(new User(null, "manager1", encoder.encode("pass"), User.Role.STORE_MANAGER));
                userRepository.save(new User(null, "admin", encoder.encode("adminpass"), User.Role.HEAD_OFFICE_MANAGER));
            }
        };

    }
}
