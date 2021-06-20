package br.com.leoneoliveira.SpringBootStudy.data.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = -3298455891319577617L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 15)
    private String gender;

    @Column(nullable = false)
    private Boolean enabled;
}
