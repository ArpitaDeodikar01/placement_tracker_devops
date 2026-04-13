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

        stage('Fetch Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/ArpitaDeodikar01/placement_tracker_devops.git'
            }
        }

        // ✅ Build WITHOUT running tests
        stage('Build Application') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        // ✅ START APP BEFORE TESTING
        stage('Start Application') {
    steps {
        echo 'Starting Spring Boot app...'
        bat 'start /B java -jar target\\placement-tracker-0.0.2-SNAPSHOT.jar'
        bat 'ping 127.0.0.1 -n 25 > nul'
    }
}

        // 🔥 THIS IS YOUR ACTUAL CI TESTING
        stage('Run Tests') {
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
                bat 'docker stop %CONTAINER_NAME% || exit 0'
                bat 'docker rm %CONTAINER_NAME% || exit 0'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 7070:8090 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: CI/CD Pipeline completed 🚀'
        }
        failure {
            echo 'FAILURE: Check logs ❌'
        }
    }
}