package mess.gestaovagas.modules.company.service;

import mess.gestaovagas.modules.company.entities.JobEntity;
import mess.gestaovagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
