pipeline {

    agent any
    tools {
        maven '3.8.4'
    }
    
    stages  {
    
    stage("build") {
        steps {
            echo 'building app'
            }
        }
        
        stage("verify") {
            steps {
                sh 'mvn clean verify'
            }
        }
        stage("test") {
            steps {
                echo 'testing application'
                sh 'mvn --version'
                }
            }
    
    }
}


