package mess.gestaovagas.modules.company.service;

import mess.gestaovagas.exceptions.UserFoundException;
import mess.gestaovagas.modules.company.entities.CompanyEntity;
import mess.gestaovagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(user ->{
            throw new UserFoundException();
        });

        return this.companyRepository.save(companyEntity);
    }
}
