package by.bsuir.prokofyev.binanceproject.service;

import org.springframework.stereotype.Service;

@Service
public class InformationService {

    public String information() {
        return "{\"course\": 58}";
    }
    public String informationError()
    {
        return "Null page";
    }
}