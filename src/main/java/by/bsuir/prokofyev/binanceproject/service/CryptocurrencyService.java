package by.bsuir.prokofyev.binanceproject.service;

import by.bsuir.prokofyev.binanceproject.entity.Cryptocurrency;
import by.bsuir.prokofyev.binanceproject.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CryptocurrencyService {
    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CryptocurrencyService(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public List<Cryptocurrency> getAllCryptocurrencies() {
        // Get the list of all cryptocurrencies from the repository
        return StreamSupport.stream(cryptocurrencyRepository.findAll().spliterator(), false).toList();
    }

    public Cryptocurrency getCryptocurrencyById(long id) {
        // Get a cryptocurrency by its ID from the repository
        return cryptocurrencyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cryptocurrency ID: " + id));
    }

    public Cryptocurrency createCryptocurrency(Cryptocurrency cryptocurrency) {
        // Save a new cryptocurrency in the repository
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public Cryptocurrency updateCryptocurrency(long id, Cryptocurrency updatedCryptocurrency) {
        // Update a cryptocurrency by its ID in the repository
        Cryptocurrency cryptocurrency = cryptocurrencyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cryptocurrency ID: " + id));

        cryptocurrency.setName(updatedCryptocurrency.getName());
        cryptocurrency.setPrice(updatedCryptocurrency.getPrice());

        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public void deleteCryptocurrency(long id) {
        // Delete a cryptocurrency by its ID from the repository
        cryptocurrencyRepository.deleteById(id);
    }
}