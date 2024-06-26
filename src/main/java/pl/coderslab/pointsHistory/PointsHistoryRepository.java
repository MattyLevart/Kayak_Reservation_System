package pl.coderslab.pointsHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.user.User;

import java.util.List;

public interface PointsHistoryRepository extends JpaRepository<PointsHistory, Long> {
    List<PointsHistory> findByUser(User user);
}
