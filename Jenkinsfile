pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    environment {
        IMAGE_NAME = "tracker-image-v2"
        CONTAINER_NAME = "tracker-container-v2"
    }

    stages {

        stage('Fetch Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Zoowee23/placement_tracker_devops.git'
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Start App for Testing') {
            steps {
                bat 'start /B java -jar target/placement-tracker-0.0.1-SNAPSHOT.jar'
                bat 'timeout /t 15'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %IMAGE_NAME% ."
            }
        }

        stage('Deploy Container') {
            steps {
                bat "docker stop %CONTAINER_NAME% || exit 0"
                bat "docker rm %CONTAINER_NAME% || exit 0"
                bat "docker run -d -p 6060:8090 --name %CONTAINER_NAME% %IMAGE_NAME%"
            }
        }
    }
}