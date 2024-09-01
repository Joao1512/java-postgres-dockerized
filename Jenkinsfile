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
        stage('Compile and Build') {
            steps {
                // Get code from GitHub repository
                git branch: 'develop', credentialsId: 'Mac-key', url: 'git@github.com:Joao1512/java-postgres-dockerized.git'
                
                dir('crud-jdbc') { 
                    // Run Maven command.
                    sh "mvn clean install -DskipTests"
                }
            }
        }
        stage('Sonar static Analysis') {
            steps {
                timeout(time: 5, unit: "MINUTES") {                      
                // Get code from GitHub repository
                    git branch: 'develop', credentialsId: 'Mac-key', url: 'git@github.com:Joao1512/java-postgres-dockerized.git'
                    
                    dir('crud-jdbc') { 
                        withSonarQubeEnv(installationName: 'Sonar Qube Server') {
                            // Run Maven command.
                            sh "mvn -Dmaven.test.failure.ignore=true clean verify org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar -Dsonar.projectKey=Joao1512_java-postgres-dockerized_AZGuhD0xj7tplXc4khLP"
                        }
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }

        stage('Tests') {
            steps {
                echo 'Test something...'
            }
        }
    }