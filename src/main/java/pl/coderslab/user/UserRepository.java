package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    void delete(User user);

    @Override
    void deleteById(Long userId);

    void deleteByEmail(String email);

    User findByEmail(String email);

    boolean existsByEmail(String email);

}


