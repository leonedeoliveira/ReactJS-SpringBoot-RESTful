package br.com.leoneoliveira.SpringBootStudy.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.*;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder({ "id", "firstName", "lastName", "address", "gender", "enabled" })
public class PersonVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = -3298455891319577617L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Boolean enabled;
}
