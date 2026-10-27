package mess.gestaovagas.modules.candidate.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Maria", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Email(message = "The field [email] must have a valid email.")
    @Schema(example = "maria@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "The field [username] should not contain spaces.")
    @Schema(example = "Mess", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @Length(min = 10, max = 100, message = "The password must be 10 to 100 characters long.")
    @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Schema(example = "Java developer", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime cratedAt;

}
