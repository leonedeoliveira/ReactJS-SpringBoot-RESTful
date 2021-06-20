package br.com.leoneoliveira.SpringBootStudy.security;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountCredentialsVO implements Serializable {

    private static final long serialVersionUID = 7337504124663565299L;

    private String username;
    private String password;

}
