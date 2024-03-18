package by.bsuir.prokofyev.binanceproject.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Wallet {
    @Id
    private long id;
    @ManyToOne
    User owner;
    @ManyToOne
    Cryptocurrency amount;
}
