package by.bsuir.prokofyev.binanceproject.api;

import by.bsuir.prokofyev.binanceproject.entity.User;
import by.bsuir.prokofyev.binanceproject.entity.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletCrud extends CrudRepository<Wallet, Long> {
}
