package com.bolsadeideas.springboot.backend.apirest.models.OutBound;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {

    private Long id;
    private String lastName;
    private String firstName;
    private String company;
    private String instructions;
    private Address address;
    private Contact contact;

}
