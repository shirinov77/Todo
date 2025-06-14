package uz.pdp.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;
}
