pipeline {
  agent any

  triggers {
    githubPush()
  }

  stages {
    stage('Build') {
      steps {
        echo 'Building...'
        sh 'mvn clean package -DskipTests'  // Update if you use Gradle or other tools
      }
    }

    stage('Docker Build') {
      steps {
        echo 'Building Docker image...'
        sh 'docker build -t accounts .'
      }
    }
  }
}
