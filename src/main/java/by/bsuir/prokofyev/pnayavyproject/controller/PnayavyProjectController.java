package by.bsuir.prokofyev.pnayavyproject.controller;

import by.bsuir.prokofyev.pnayavyproject.service.InformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PnayavyProjectController {
    private final InformationService informationService;

    public PnayavyProjectController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping(value = "/hello" , produces = "application/json")
    public String sayHello(@RequestParam(required = false) String name) {
        return !(name.equals("USDT"))  ? informationService.informationError() : informationService.information();
    }
}