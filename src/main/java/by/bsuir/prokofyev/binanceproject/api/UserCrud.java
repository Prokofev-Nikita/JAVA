package by.bsuir.prokofyev.binanceproject.api;

import by.bsuir.prokofyev.binanceproject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserCrud extends CrudRepository<User, Long> {
}
