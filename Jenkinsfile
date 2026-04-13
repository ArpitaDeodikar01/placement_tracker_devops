pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    environment {
        IMAGE_NAME = "tracker-image-v3"
        CONTAINER_NAME = "tracker-container-v3"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/ArpitaDeodikar01/placement_tracker_devops.git'
            }
        }

        stage('Clean Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Verify Build Output') {
            steps {
                bat 'dir target'
            }
        }

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Start Application (Test Mode)') {
            steps {
                bat 'start /B java -jar target/*.jar'
                bat 'timeout 15'
            }
        }

        stage('Selenium Integration Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat 'docker rm -f %CONTAINER_NAME% || exit 0'
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker run -d -p 7070:8090 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }
    }

    post {
        success {
            echo 'CI/CD SUCCESS 🚀 Application deployed successfully'
        }
        failure {
            echo 'CI/CD FAILED ❌ Check logs'
        }
    }
}
