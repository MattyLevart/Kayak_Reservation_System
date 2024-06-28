package pl.coderslab.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.role.Role;
import pl.coderslab.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserSecImpl implements UserSecService {

    private final UserRepository userRepository;

    public UserSecImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
