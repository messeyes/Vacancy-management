package mess.gestaovagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Email(message = "The field [email] must have a valid email.")
    private String email;

    @Pattern(regexp = "\\S+", message = "The field [username] should not contain spaces.")
    private String username;

    @Length(min = 10, max = 100, message = "The password must be 10 to 100 characters long.")
    private String password;
    private String description;
    private String curriculum;


}
