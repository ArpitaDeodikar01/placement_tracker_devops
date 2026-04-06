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
                url: 'https://github.com/Zoowee23/placement_tracker_devops.git'
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Verify JAR Exists') {
            steps {
                bat 'dir target'
            }
        }

        stage('Start App for Selenium Testing') {
            steps {
                // start app in background
                bat 'start /B java -jar target/*.jar'

                // wait for app to start
                bat 'ping 127.0.0.1 -n 15 > nul'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build --no-cache -t %IMAGE_NAME% .'
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker stop %CONTAINER_NAME% || exit 0'
                bat 'docker rm %CONTAINER_NAME% || exit 0'
                bat 'docker run -d -p 7070:8090 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
        success {
            echo 'SUCCESS: Application deployed successfully 🚀'
        }
        failure {
            echo 'FAILURE: Check logs for debugging ❌'
        }
    }
}