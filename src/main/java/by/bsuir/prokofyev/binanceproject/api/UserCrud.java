package by.bsuir.prokofyev.binanceproject.api;

import by.bsuir.prokofyev.binanceproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface UserCrud extends JpaRepository<User, Long> {

    List<User> findAllByIdIn(@Param("ids") List<Long> ids);

    @RestResource(path = "names")
    @Query("SELECT u FROM User u WHERE u.username LIKE %:username%")
    List<User> findAllByUsernameContainsIgnoreCase(@Param("username") String username);
}
