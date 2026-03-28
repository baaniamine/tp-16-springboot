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

<img width="1900" height="983" alt="image" src="https://github.com/user-attachments/assets/5a3fe11c-d419-4799-93ea-3d9e93eea45a" />

### Health Check

<img width="1910" height="993" alt="image" src="https://github.com/user-attachments/assets/2688a1a9-c1d7-4f1a-b43e-c42c4d459307" />

### Grafana login page
<img width="1918" height="807" alt="image" src="https://github.com/user-attachments/assets/367379f6-2f01-45c9-959f-1b978083b6f9" />
<img width="1905" height="830" alt="image" src="https://github.com/user-attachments/assets/67a75021-1d13-4481-97df-300d2cea4d63" />


### Prometheus Dashboard

<img width="1919" height="877" alt="image" src="https://github.com/user-attachments/assets/ee5cd64b-2693-460d-824f-16aa2661ae2c" />

### Grafana Dashboard

<img width="1919" height="1003" alt="image" src="https://github.com/user-attachments/assets/2c457896-a362-417d-8ec9-f80230402e63" />
<img width="1902" height="872" alt="image" src="https://github.com/user-attachments/assets/b040de19-fc83-4c72-9232-b5430e4f8a60" />
