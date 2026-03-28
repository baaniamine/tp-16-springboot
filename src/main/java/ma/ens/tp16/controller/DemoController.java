package ma.ens.tp16.controller;

import ma.ens.tp16.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        logger.info("Acces a la page d'accueil");
        return "Bienvenue sur l'application TP16 de monitoring Spring Boot!";
    }

    @GetMapping("/about")
    public String about() {
        logger.info("Requete recue sur /about");
        return service.aboutProject();
    }

    @GetMapping("/process")
    public String process() {
        logger.info("Requete recue sur /process");
        return service.processData();
    }

    @GetMapping("/slow")
    public String slowProcess() {
        logger.info("Requete recue sur /slow");
        return service.slowProcess();
    }

    @GetMapping("/error")
    public ResponseEntity<String> simulateError() {
        logger.info("Requete recue sur /error");
        try {
            service.simulateError();
            return ResponseEntity.ok("Pas d'erreur");
        } catch (RuntimeException e) {
            logger.error("Erreur capturee: {}", e.getMessage());
            return ResponseEntity.internalServerError()
                    .body("Erreur: " + e.getMessage());
        }
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        logger.debug("Health check effectue");
        return ResponseEntity.ok("Application en fonctionnement");
    }
}
