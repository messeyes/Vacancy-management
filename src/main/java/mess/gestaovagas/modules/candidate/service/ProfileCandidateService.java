package mess.gestaovagas.modules.candidate.service;


import mess.gestaovagas.modules.candidate.CandidateRepository;
import mess.gestaovagas.modules.candidate.dto.AuthCandidateResponseDTO;
import mess.gestaovagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate){
       var candidate =  this.candidateRepository.findById(idCandidate)
               .orElseThrow(()-> {
                   throw new UsernameNotFoundException("User not found");
               });

       var candidateDTO = ProfileCandidateResponseDTO.builder()
               .description(candidate.getDescription())
               .username(candidate.getUsername())
               .email(candidate.getEmail())
               .name(candidate.getName())
               .id(candidate.getId())
               .build();

       return candidateDTO;

    }
}
