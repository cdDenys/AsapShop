package asapshop.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @OneToMany
    private List<Product> products;

    @Column(name = "cartPrice", nullable = false)
    private BigDecimal cartPrice = BigDecimal.ZERO;

}
