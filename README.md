# Java and Postgres Dockerized

# How to run:

1. Build the compose file for the first time
    
    ```powershell
    docker-compose up
    ```
    
2. After changing source code, rebuild backend image to see the changes.
    
    ```powershell
    docker-compose build backend
    ```
    
3. Repeat first step, so the database container status will be kept as Running, while the backend container will be recreated.
4. Remove old images, builds, unused stuff. 
    
    ```powershell
    docker prune -a
    ```
