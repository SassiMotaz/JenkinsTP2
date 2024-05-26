pipeline {
    agent any
    tools {
        maven 'maven_3_9_6'
    }

    stages {
        stage('Clean up') {
            steps {
                deleteDir()
            }
        }
        stage('Clone repo') {
            steps {
                script {
                    // Clone the repository; use sh for Unix and bat for Windows
                    if (isUnix()) {
                        sh 'git clone https://github.com/SassiMotaz/JenkinsTP2.git'
                    } else {
                        bat 'git clone https://github.com/SassiMotaz/JenkinsTP2.git'
                    }
                }
            }
        }
        stage('Generate backend image') {
            steps {
                dir('JenkinsTP2') {  // Ensure this is the correct directory where pom.xml is located
                    script {
                        // Use sh for Unix and bat for Windows
                        if (isUnix()) {
                            sh 'mvn clean install'
                            sh 'docker build -t backend .'
                        } else {
                            bat 'mvn clean install'
                            bat 'docker build -t backend .'
                        }
                    }
                }
            }
        }
        stage('Run backend compose') {
            steps {
                dir('JenkinsTP2') {
                    // Use docker-compose to start the services
                    // Make sure docker-compose.yml is in the 'JenkinsTP2' directory
                    script {
                        if (isUnix()) {
                            sh 'docker-compose up -d'
                        } else {
                            bat 'docker-compose up -d'
                        }
                    }
                }
            }
        }
    }
}
