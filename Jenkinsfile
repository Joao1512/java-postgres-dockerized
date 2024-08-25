pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get code from GitHub repository
               git branch: 'develop', credentialsId: 'Mac-key', url: 'git@github.com:Joao1512/java-postgres-dockerized.git'
                
                dir('crud-jdbc') { 
                    // Run Maven command.
                    sh "mvn -Dmaven.test.failure.ignore=true clean install -DskipTests"
                }
            }
        }
        stage('Stage 2') {
            steps {
                echo 'Stage 2'
            }
        }
    }
}