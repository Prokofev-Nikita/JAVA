package by.bsuir.prokofyev.binanceproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cryptocurrency {
    @Id
    private long id;
    private String name;
    private double price;
}
