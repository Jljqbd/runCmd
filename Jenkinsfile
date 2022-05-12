Jenkinsfile('run Command web code')
pipeline {
    tools{
        maven 'maven'
        jdk   'jdk1.8'
    }
    agent any
    stages {
        stage('runCmd build'){
            steps{
                echo 'runCmd building...'
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
       stage('Test'){
           steps{
               echo 'runCmd Testing...'
               sh 'java -version'
           }
       }
       stage('Reploy'){
           steps{
               echo 'runCmd Runing...'
               sh 'cd target'
               sh 'java - jar runCmd-0.0.1-SNAPSHOT.war server.port=8082'
           }
       }
       
        
    }
}