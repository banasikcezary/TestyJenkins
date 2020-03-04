pipeline {
    agent any
    stages {
        stage('Build test code') {
            steps {
                sh 'gradlew clean install -DskipTests'
            }
        }
        stage('Execute test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'allure-results']]
                    ])
                }
            }
        }
    }
}