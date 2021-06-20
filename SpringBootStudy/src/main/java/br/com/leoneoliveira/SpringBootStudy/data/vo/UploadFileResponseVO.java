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
public class UploadFileResponseVO extends RepresentationModel implements Serializable {


    private static final long serialVersionUID = -4390218208275684277L;

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
