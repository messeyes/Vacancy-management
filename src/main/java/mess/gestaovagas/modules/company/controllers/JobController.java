package mess.gestaovagas.modules.company.controllers;

import jakarta.validation.Valid;
import mess.gestaovagas.modules.company.entities.JobEntity;
import mess.gestaovagas.modules.company.service.CreateJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobService createJobService;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        return this.createJobService.execute(jobEntity);
    }
}
