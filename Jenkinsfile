pipeline {
  agent any

  options {
    timeout(time: 5, unit: 'MINUTES')
  }

  environment {
    ARTIFACT_ID = "pedrolop90/usuario-test:${env.BUILD_NUMBER}"
  }

  stages {
    stage('Build') {
      steps {
        script {
           dockerImage = docker.build "${env.ARTIFACT_ID}"
        }
      }
    }
    stage('Publish') {
      when {
        branch 'master'
      }
      steps {
        script {
          docker.withRegistry("", "DockerHubCredentials") {
            dockerImage.push()
          }
        }
      }
    }
  }
}
