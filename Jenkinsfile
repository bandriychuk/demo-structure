node {
       stage("checkout repo"){
             git branch: 'master',
             credentialsId: 'e900de22b8ed0f144095827c4bbbd75f6c86d67f',
             url: 'https://github.com/bandriychuk/demo-structure.git'
       }

       stage("build"){
            sh "./gradlew api-test:assemble"
       }

       stage("run api tests"){
            sh "./gradlew api-test:test -Dlogging=${LOGGING}"
       }

       stage("run ui tests"){
            sh "./gradlew ui-test:test -Dlogging=${LOGGING}"
       }

       allure([
            includeProperties = false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'api-test/build/allure-results'],[path: 'ui-test/build/allure-results']]
       ])
}