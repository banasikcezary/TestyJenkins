pipeline {
    agent any
    stages {
        stage('Build test code') {
            steps {
                sh 'clean install -DskipTests'
            }
        }
        stage('Execute test') {
            steps {
                sh 'test'
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