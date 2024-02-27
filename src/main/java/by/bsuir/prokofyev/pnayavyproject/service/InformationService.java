package by.bsuir.prokofyev.pnayavyproject.service;

import org.springframework.stereotype.Service;

@Service
public class InformationService {

    public String information() {
        return "{\ncourse: 58\n}";
    }
    public String informationError()
    {
        return "Null page";
    }
}