package by.bsuir.prokofyev.binanceproject.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "my_user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String username;
}
