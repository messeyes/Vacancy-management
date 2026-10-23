package mess.gestaovagas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Vacancy Management",
                description = "API responsible for the management of vanacies",
                version = "1"
        )
)
public class VacancyManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacancyManagementApplication.class, args);
    }

}
