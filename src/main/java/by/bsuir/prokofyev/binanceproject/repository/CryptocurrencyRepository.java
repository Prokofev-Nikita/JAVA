package by.bsuir.prokofyev.binanceproject.repository;

import by.bsuir.prokofyev.binanceproject.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptocurrencyRepository extends CrudRepository<Cryptocurrency, Long> {

}