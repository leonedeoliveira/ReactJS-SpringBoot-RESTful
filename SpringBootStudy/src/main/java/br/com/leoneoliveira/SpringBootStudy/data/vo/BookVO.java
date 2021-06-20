package br.com.leoneoliveira.SpringBootStudy.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder({ "id", "author", "launchDate", "price", "title" })
public class BookVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 313191616785605302L;


    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;
}
