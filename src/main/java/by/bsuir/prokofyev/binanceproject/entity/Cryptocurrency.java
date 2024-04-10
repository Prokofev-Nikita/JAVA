package by.bsuir.prokofyev.binanceproject.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cryptocurrency {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;

    @ManyToMany
    @JoinTable(name = "wallet", joinColumns = @JoinColumn(name = "amount_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    List<User> users;
}
