package by.bsuir.prokofyev.binanceproject.api;

import by.bsuir.prokofyev.binanceproject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCrud extends CrudRepository<User, Long> {
    List<User> findAllByIdIn(@Param("ids") List<Long> ids);

    List<User> findAllByUsernameContainsIgnoreCase(@Param("username") String username);
}
