pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project'
            }
        }
        stage('DEV') {
            steps {
                echo 'Deploy to Dev'
            }
            
        }
        
        stage('QA') {
            steps {
                echo 'Deploy to Qa'
            }
        }
        stage('Regression') {
            steps {
                echo 'Regression in Qa'
            }
        }
        stage('Sanity') {
            steps {
                echo 'Sanity in Qa'
            }
        }
        stage('PROD') {
            steps {
                echo 'Deploy in  in prod'
            }
        }
    }
    }


   