pipeline {
    agent any

    stages {
        stage('Clean Workspace') {
            steps {
                // Clean workspace before building
                deleteDir()  // Cleans up the workspace
            }
        }
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/VikkiJoseph/Accounts.git', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                sh './mvnw clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t accounts .'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Running Docker container...'
                sh 'docker run -d -p 8080:8080 accounts'
            }
        }
    }
}
