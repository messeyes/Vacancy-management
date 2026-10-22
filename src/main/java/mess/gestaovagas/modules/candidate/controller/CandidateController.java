package mess.gestaovagas.modules.candidate.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import mess.gestaovagas.modules.candidate.CandidateEntity;
import mess.gestaovagas.modules.candidate.service.CreateCandidateService;
import mess.gestaovagas.modules.candidate.service.ProfileCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateService createCandidateService;

    @Autowired
    private ProfileCandidateService profileCandidateService;

    @PostMapping("/")
    public ResponseEntity<Object>create(@Valid @RequestBody CandidateEntity candidateEntity){
        try {
            var result = this.createCandidateService.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('candidate')")
    public ResponseEntity<Object> get(HttpServletRequest request){
        var idCandidate = request.getAttribute("candidate_id");
        try {
            var profile = this.profileCandidateService.execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
