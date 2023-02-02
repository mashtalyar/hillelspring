package ua.ithillel.hillelspring.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private int phone;

}

