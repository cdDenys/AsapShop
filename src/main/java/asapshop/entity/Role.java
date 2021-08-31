package asapshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private Long id;

    private String name;

    public Role() {

    }

    public Role(String name) {
        super();
        this.name = name;
    }


}
