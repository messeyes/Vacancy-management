package mess.gestaovagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "vacancy for junior developers", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "GYMPass, health plan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "JUNIOR", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;
}
