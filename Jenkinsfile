pipeline {
  agent any

  options {
    timeout(time: 50, unit: 'MINUTES')
  }

  environment {
    ARTIFACT_ID = "pedrolop90/usuario-test:31.0"
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
        branch 'develop'
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
