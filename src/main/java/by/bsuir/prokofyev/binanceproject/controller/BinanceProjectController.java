package by.bsuir.prokofyev.binanceproject.controller;

import by.bsuir.prokofyev.binanceproject.service.InformationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BinanceProjectController {
    private final InformationService informationService;

    public BinanceProjectController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping(value = "/binance" , produces = "application/json")
    public String ValidateInput(@RequestParam(required = false) String name) {
        if (name == null)
        {
            return informationService.informationError();
        }
        return !(name.equals("USDT")) ? informationService.informationError() : informationService.information();
    }
}