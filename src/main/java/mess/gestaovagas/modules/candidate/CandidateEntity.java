package mess.gestaovagas.modules.candidate;

import lombok.Data;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String description;
    private String curriculum;


}
