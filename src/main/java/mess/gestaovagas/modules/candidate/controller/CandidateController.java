package mess.gestaovagas.modules.candidate.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import mess.gestaovagas.modules.candidate.entity.CandidateEntity;
import mess.gestaovagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import mess.gestaovagas.modules.candidate.service.CreateCandidateService;
import mess.gestaovagas.modules.candidate.service.ListAllJobsByFilterService;
import mess.gestaovagas.modules.candidate.service.ProfileCandidateService;
import mess.gestaovagas.modules.company.entities.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/candidate")
@Tag(name = "Candidate", description = "Candidate's information")
public class CandidateController {

    @Autowired
    private CreateCandidateService createCandidateService;

    @Autowired
    private ProfileCandidateService profileCandidateService;

    @Autowired
    private ListAllJobsByFilterService listAllJobsByFilterService;

    @PostMapping("/")
    @Operation(summary = "Candidate's registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CandidateEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "User already exists.")
    })
    public ResponseEntity<Object>create(@Valid @RequestBody CandidateEntity candidateEntity){
        try {
            var result = this.createCandidateService.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    @Operation(summary = "Candidate's profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ProfileCandidateResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "User not found.")
    })
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> get(HttpServletRequest request){
        var idCandidate = request.getAttribute("candidate_id");
        try {
            var profile = this.profileCandidateService.execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/job")
    @PreAuthorize("hasRole('CANDIDATE')")
    @Operation(summary = "List of vacancies available for the candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = JobEntity.class)))
            })
    })
    @SecurityRequirement(name = "jwt_auth")
    public List<JobEntity> findJobByFilter(@RequestParam String filter){
        return this.listAllJobsByFilterService.execute(filter);
    }

}
