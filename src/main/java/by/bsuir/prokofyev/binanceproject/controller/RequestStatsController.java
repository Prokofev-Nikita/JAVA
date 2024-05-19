package by.bsuir.prokofyev.binanceproject.controller;

import org.springframework.http.ResponseEntity;
import by.bsuir.prokofyev.binanceproject.counter.RequestCounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")

public class RequestStatsController
{
    private RequestCounterService requestCounterService;

    public RequestStatsController(RequestCounterService requestCounterService) {
        this.requestCounterService = requestCounterService;
    }

    @GetMapping
    public ResponseEntity<Integer> getRequestStats() {
        return ResponseEntity.ok(requestCounterService.getCount());
    }
}
