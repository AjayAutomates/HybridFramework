pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/AjayAutomates/HybridFramework.git'
            }
        }

        stage('Build Project') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'test-output/**/*.*', fingerprint: true
            }
        }
    }
}
