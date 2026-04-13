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

        stage('Build Application') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Verify Build Output') {
            steps {
                bat 'dir target'
            }
        }

       stage('Start Application (Required for Selenium)') {
    steps {
        echo 'Starting Spring Boot application...'

        bat '''
        for %%f in (target\\*.jar) do (
            start "" java -jar "%%f"
        )
        '''

        echo 'Waiting for application to boot...'
        bat 'ping 127.0.0.1 -n 25 > nul'
    }
}

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Selenium Integration Tests') {
            steps {
                echo 'Running Selenium tests...'
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
            echo 'SUCCESS: CI/CD Pipeline completed successfully 🚀'
        }
        failure {
            echo 'FAILURE: Check logs for debugging ❌'
        }
    }
}
