package by.bsuir.prokofyev.pnayavyproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BinanceServerController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false) String name) {
        return name == null ? "You are noname, looser" : "58";
    }
}