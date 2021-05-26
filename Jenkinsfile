node {
      stage("checkout repo"){
          git branch: 'master',
          credentialsId: 'ad523aab-5236-4c3f-b332-c94fbe5fd5cb',
          url: 'https://github.com/bandriychuk/demo-structure.git'
      }

      stage("build"){
           sh "./gradlew clean api-test:assemble"
           }

      stage("run api tests"){
           sh "./gradlew api-test:test"
           }

//       stage("run ui tests"){
//            sh "./gradlew ui-test:test"
//            }

//       stage('Publish tests results') {
          allure([
              includeProperties: true,
              jdk              : '',
              properties       : [],
              reportBuildPolicy: 'ALWAYS',
              results          : [[path: 'build/reports/api-test/build/allure-results']]
          ])
//       }
}