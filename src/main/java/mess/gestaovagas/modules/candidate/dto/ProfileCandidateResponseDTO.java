package mess.gestaovagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Java developer")
    private String description;
    @Schema(example = "Mess")
    private String username;
    @Schema(example = "mess@gmail.com")
    private String email;
    private UUID id;
    @Schema(example = "Maria Eduarda")
    private String name;
}
