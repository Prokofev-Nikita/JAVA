package by.bsuir.prokofyev.binanceproject.api;

import by.bsuir.prokofyev.binanceproject.entity.Cryptocurrency;
import by.bsuir.prokofyev.binanceproject.entity.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface CryptocurrencyCrud extends CrudRepository<Cryptocurrency, Long> {
}
