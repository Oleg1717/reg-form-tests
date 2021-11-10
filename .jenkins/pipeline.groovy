pipeline {
    agent any

    parameters{
        string(defaultValue: '5', name: 'THREADS')
        choice(choices: ['chrome', 'firefox'], name: 'BROWSER_NAME')
        choice(choices: ['master', 'api'], name: 'BRANCH_NAME')
        string(defaultValue: '3.1.1', name: 'ALLURE_NOTIFICATIONS_VERSION')
    }

    stages {
        stage('Source code') {
            steps {
                git 'https://github.com/Oleg1717/reg-form-tests'
            }
        }

        stage('Build') {
            steps {
                withAllureUpload(name: '${JOB_NAME} - #${BUILD_NUMBER}', projectId: '398', results: [[path: 'build/allure-results']], serverId: 'allure-server') {
                    sh '/home/testuser/.sdkman/candidates/gradle/6.8.3/bin/gradle clean test -Dthreads=${THREADS} -Dbrowser=${BROWSER_NAME}'
                }
            }
        }

    }

    post {
        always {
            allure results: [[path: 'build/allure-results']]
            sh '''java  \\
				"-DprojectName=REG-FORM-TESTS" \\
				"-Denv=prod" \\
				"-DreportLink=${BUILD_URL}" \\
				"-Dconfig.file=/home/testuser/.allure-notifications/config/ov_autotests_bot.json" \\
				-jar /home/testuser/.allure-notifications/releases/allure-notifications-${ALLURE_NOTIFICATIONS_VERSION}.jar '''
        }
    }
}

