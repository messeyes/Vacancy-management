package mess.gestaovagas.modules.candidate.service;

import mess.gestaovagas.exceptions.JobNotFoundException;
import mess.gestaovagas.exceptions.UserNotFoundException;
import mess.gestaovagas.modules.candidate.entity.ApplyJobEntity;
import mess.gestaovagas.modules.candidate.repository.ApplyJobRepository;
import mess.gestaovagas.modules.candidate.repository.CandidateRepository;
import mess.gestaovagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ApplyJobCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate).orElseThrow(()
                -> {
                    throw new UserNotFoundException();
                });


        this.jobRepository.findById(idJob).orElseThrow(()
                -> {
                    throw new JobNotFoundException();
                });

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }



}
