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
      steps {
        script {
          docker.withRegistry("", "DockerHubCredentials") {
            dockerImage.push()
          }
        }
      }
    }
    stage('Deployment') {
      steps {
        build job: 'test_ssh', parameters: [string(name: 'ARTIFACT_ID', value: "${env.ARTIFACT_ID}")], wait: false
      }
    }
  }
}
