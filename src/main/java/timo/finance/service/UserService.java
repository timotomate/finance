package timo.finance.service;

import org.springframework.stereotype.Service;
import timo.finance.domain.User;
import timo.finance.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }
}