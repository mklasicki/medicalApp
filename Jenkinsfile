pipeline {

    agent any
    tools {
        maven 'Maven 3.8.4'
    }
    
    stages  {
    
    stage("build") {
        steps {
            echo 'building app'
            }
        }
        stage("test") {
            steps {
                echo 'testing application'
                sh 'mvn -v'
                }
            }
    
    }
}


