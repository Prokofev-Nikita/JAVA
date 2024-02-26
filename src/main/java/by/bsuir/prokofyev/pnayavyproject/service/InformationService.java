package by.bsuir.prokofyev.pnayavyproject.service;

import org.springframework.stereotype.Service;

@Service
public class InformationService {

    public String information() {
        return "58";
    }
    public String informationError()
    {
        return "Null page";
    }
}