pipeline {
    agent any
    tools {
            jdk 'JDK'
            maven 'Maven'
          }
    stages {
        stage('Build test code') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Execute test') {
            steps {
                sh 'mvn test -DtestSuite=testing.xml'
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