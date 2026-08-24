pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            environment {
                JAVA_HOME = '/usr/lib/jvm/java-21-amazon-corretto'
                PATH = "${JAVA_HOME}/bin:${env.PATH}"
            }
            steps {
                sh 'mvn -B clean package'
            }
        }
        stage('Build Image') {
            steps {
                sh 'docker build -t team-skeleton .'
            }
        }
        stage('Smoke Test') {
            steps {
                sh 'docker run --rm team-skeleton'
            }
        }
    }
}
