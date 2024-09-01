# Java and Postgres with Jenkins - Dockerized

## How to run Application:

1. Build the compose file for the first time
    
    ```powershell
    docker-compose up
    ```
    
2. After changing source code, rebuild backend image to see the changes.
    
    ```powershell
    docker-compose build backend
    ```
    
3. Repeat first step, so the database container status will be kept as Running, while the backend container will be recreated.

## Running Jenkins and SonarQube

  Up the compose files 

```powershell
docker-compose -f compose-jenkins.yaml up -d
docker-compose -f compose-sonar.yaml up -d
```

Access Jenkins and Sonar on ports 8003 and 9000 respectively.

## Setting up Integration between Git, Jenkins and SonarQube

- Create a webhook on your repository and point it to *[machine-ip]:8003/github-webhook*
- Create a GithubApp and provide it's credentials on Sonar Dashboard, so Sonar can access your repository. More info [here](https://docs.sonarsource.com/sonarqube/latest/devops-platform-integration/github-integration/setting-up-at-global-level/setting-up-github-app/).
- On Jenkins, go to Manage Jenkins > System and install a Sonar Cube Server named “Sonar Qube Server”. **Obs**: you must have installed Sonar Cube Plugin for Jenkins before it.
- On Sonar webhooks, create a new one with the address  *[machine-ip]:8003/sonarqube-webhook/*