pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Maven clean install') {
            steps {
                // Get code from GitHub repository
               git branch: 'develop', credentialsId: 'Mac-key', url: 'git@github.com:Joao1512/java-postgres-dockerized.git'
                
                dir('crud-jdbc') { 
                    withSonarQubeEnv() {
                        // Run Maven command.
                        sh "mvn -Dmaven.test.failure.ignore=true clean install verify sonar:sonar -Dsonar.projectKey=Joao1512_java-postgres-dockerized_AZGuET8kLln6lOOQkp7r"
                    }
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Test something...'
            }
        }
    }
}