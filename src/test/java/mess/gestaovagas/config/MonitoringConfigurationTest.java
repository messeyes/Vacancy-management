package mess.gestaovagas.config;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MonitoringConfigurationTest {

    @Test
    public void should_expose_actuator_metrics_endpoints() throws Exception {
        var properties = Files.readString(Path.of("src/main/resources/application.properties"));

        assertTrue(properties.contains("management.endpoints.web.exposure.include=health,metrics,prometheus"));
        assertTrue(properties.contains("management.endpoint.prometheus.enabled=true"));
        assertTrue(properties.contains("server.tomcat.mbeanregistry.enabled=true"));
    }

    @Test
    public void should_scrape_actuator_prometheus_endpoint() throws Exception {
        var prometheusConfig = Files.readString(Path.of("config/prometheus.yml"));

        assertTrue(prometheusConfig.contains("metrics_path: \"/actuator/prometheus\""));
        assertTrue(prometheusConfig.contains("targets: [\"host.docker.internal:8080\"]"));
        assertTrue(prometheusConfig.contains("application: \"api-gestao-vagas\""));
    }

    @Test
    public void should_persist_grafana_data() throws Exception {
        var dockerCompose = Files.readString(Path.of("docker-compose.yml"));

        assertTrue(dockerCompose.contains("grafana_data:/var/lib/grafana"));
        assertTrue(dockerCompose.contains("./config/prometheus.yml:/etc/prometheus/prometheus.yml"));
    }
}
