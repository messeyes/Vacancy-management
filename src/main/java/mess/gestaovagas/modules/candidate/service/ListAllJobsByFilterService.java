package mess.gestaovagas.modules.candidate.service;

import mess.gestaovagas.modules.company.entities.JobEntity;
import mess.gestaovagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterService {

    @Autowired
    private JobRepository jobRepository;


    public List<JobEntity> execute(String filter){
        return this.jobRepository.findByDescriptionContaining(filter);

    }
}
