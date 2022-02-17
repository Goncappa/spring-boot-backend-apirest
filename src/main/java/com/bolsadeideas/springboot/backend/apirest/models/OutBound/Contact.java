package com.bolsadeideas.springboot.backend.apirest.models.OutBound;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private Long id;

    private String email;

}
