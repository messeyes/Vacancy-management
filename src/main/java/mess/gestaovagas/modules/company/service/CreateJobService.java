package mess.gestaovagas.modules.company.service;

import mess.gestaovagas.exceptions.CompanyNotFoundException;
import mess.gestaovagas.modules.company.entities.JobEntity;
import mess.gestaovagas.modules.company.repositories.CompanyRepository;
import mess.gestaovagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}