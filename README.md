# TP16 - Monitoring Spring Boot

Projet Spring Boot de monitoring et supervision avec Actuator, Prometheus et Grafana.

Le projet tourne sur le port `8082`.

## Endpoints utiles

- Accueil : `http://localhost:8082/`
- About : `http://localhost:8082/about`
- Health check : `http://localhost:8082/health-check`
- Actuator health : `http://localhost:8082/actuator/health`
- Actuator info : `http://localhost:8082/actuator/info`
- Actuator metrics : `http://localhost:8082/actuator/metrics`
- Actuator prometheus : `http://localhost:8082/actuator/prometheus`
- Prometheus : `http://localhost:9090`
- Grafana : `http://localhost:3000`

## Lancement

### Avec Maven Wrapper

```powershell
.\mvnw.cmd spring-boot:run
```

### Avec Docker Compose

```powershell
docker compose up -d
```

## Captures d'ecran

Place tes captures dans `docs/screenshots/` avec les noms ci-dessous.

### Page d'accueil

![Page d'accueil](docs/screenshots/home.png)

### Health Check

![Health Check](docs/screenshots/health-check.png)

### Actuator Health

![Actuator Health](docs/screenshots/actuator-health.png)

### Actuator Info

![Actuator Info](docs/screenshots/actuator-info.png)

### Actuator Metrics

![Actuator Metrics](docs/screenshots/actuator-metrics.png)

### Actuator Prometheus

![Actuator Prometheus](docs/screenshots/actuator-prometheus.png)

### Prometheus Dashboard

![Prometheus Dashboard](docs/screenshots/prometheus-dashboard.png)

### Grafana Dashboard

![Grafana Dashboard](docs/screenshots/grafana-dashboard.png)
