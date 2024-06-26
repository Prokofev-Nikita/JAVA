package by.bsuir.prokofyev.binanceproject.entity;


import javax .persistence.*;
import lombok.Data;

@Data
@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    User owner;
    @ManyToOne
    Cryptocurrency amount;
    private double balance;
}
