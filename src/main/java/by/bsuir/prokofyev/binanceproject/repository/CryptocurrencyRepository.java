package by.bsuir.prokofyev.binanceproject.repository;

import by.bsuir.prokofyev.binanceproject.entity.Cryptocurrency;
import org.springframework.data.repository.CrudRepository;

public interface CryptocurrencyRepository extends CrudRepository<Cryptocurrency, Long> {
}
