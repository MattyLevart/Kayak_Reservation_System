package pl.coderslab.user;

public interface UserSecService {
    User findByEmail(String name);

    void saveUser(User user);
}
