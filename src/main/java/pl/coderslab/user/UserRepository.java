package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    void delete(User user);

    @Override
    void deleteById(Long userId);


    User findByEmail(String email);

    Optional<User> findUserByEmail(String email);


}


