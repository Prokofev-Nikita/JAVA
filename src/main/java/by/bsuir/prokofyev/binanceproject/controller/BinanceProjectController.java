package by.bsuir.prokofyev.binanceproject.controller;

import by.bsuir.prokofyev.binanceproject.entity.Cryptocurrency;
import by.bsuir.prokofyev.binanceproject.repository.CryptocurrencyRepository;
import by.bsuir.prokofyev.binanceproject.service.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/binance")
class BinanceProjectController {

    private final CryptocurrencyService cryptocurrencyService;

    @Autowired
    public BinanceProjectController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping
    public List<Cryptocurrency> getAllCryptocurrencies() {
        // Get the list of all cryptocurrencies
        return cryptocurrencyService.getAllCryptocurrencies();
    }

    @PostMapping
    public Cryptocurrency createCryptocurrency(@RequestBody Cryptocurrency cryptocurrency) {
        // Create a new cryptocurrency
        return cryptocurrencyService.createCryptocurrency(cryptocurrency);
    }

    @GetMapping("/{id}")
    public Cryptocurrency getCryptocurrencyById(@PathVariable("id") long id) {
        // Get a cryptocurrency by its ID
        return cryptocurrencyService.getCryptocurrencyById(id);
    }

    @PutMapping("/{id}")
    public Cryptocurrency updateCryptocurrency(@PathVariable("id") long id, @RequestBody Cryptocurrency updatedCryptocurrency) {
        // Update a cryptocurrency by its ID
        return cryptocurrencyService.updateCryptocurrency(id, updatedCryptocurrency);
    }

    @DeleteMapping("/{id}")
    public void deleteCryptocurrency(@PathVariable("id") long id) {
        // Delete a cryptocurrency by its ID
        cryptocurrencyService.deleteCryptocurrency(id);
    }
}