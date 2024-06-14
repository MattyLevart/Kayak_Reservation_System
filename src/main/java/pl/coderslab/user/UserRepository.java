package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    void delete(User user);

    @Override
    void deleteById(Long userId);
}
