package ma.ens.tp16.service;

import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    public String aboutProject() {
        logger.info("Consultation des informations du projet TP16");
        Metrics.counter("custom.requests.count", "type", "about").increment();
        return "TP16 - Monitoring, logging et metriques Spring Boot";
    }

    public String processData() {
        logger.info("Demarrage du traitement des donnees");

        // Increment a custom metric for monitoring demos.
        Metrics.counter("custom.requests.count", "type", "process").increment();

        try {
            // Simulate some work so metrics and logs are visible.
            Thread.sleep(500);
            logger.debug("Traitement en cours...");
        } catch (InterruptedException e) {
            logger.error("Erreur dans le traitement", e);
            Metrics.counter("custom.requests.errors", "type", "process").increment();
            Thread.currentThread().interrupt();
            return "Erreur lors du traitement";
        }

        logger.info("Traitement termine avec succes");
        return "Traitement effectue";
    }

    public String simulateError() {
        logger.warn("Simulation d'une erreur");
        Metrics.counter("custom.requests.errors", "type", "simulated").increment();
        throw new RuntimeException("Erreur simulee pour le monitoring");
    }

    public String slowProcess() {
        logger.info("Demarrage d'un traitement lent");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Interruption du traitement lent", e);
            Thread.currentThread().interrupt();
        }
        logger.info("Traitement lent termine");
        return "Traitement lent effectue";
    }
}
