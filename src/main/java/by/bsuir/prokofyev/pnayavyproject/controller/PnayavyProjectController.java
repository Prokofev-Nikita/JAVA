package by.bsuir.prokofyev.pnayavyproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PnayavyProjectController {
    @GetMapping(value = "/hello" , produces = "application/json")
    public String sayHello(@RequestParam(required = false) String name) {
        return name == null ? "Null page" : "{\nCourse: 58\n}";
    }
}