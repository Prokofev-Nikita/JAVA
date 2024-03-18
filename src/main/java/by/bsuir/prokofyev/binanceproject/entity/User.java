package by.bsuir.prokofyev.binanceproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private long id;
    private String username;
}
