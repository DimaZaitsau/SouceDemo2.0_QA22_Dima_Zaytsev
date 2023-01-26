pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Run Selenium Tests') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/DimaZaitsau/SouceDemo2.0_QA22_Dima_Zaytsev'

                // Run Maven on a Unix agent.
                bat "mvn clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}