package br.com.leoneoliveira.SpringBootStudy.data.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = -9035636955666413850L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }
}
