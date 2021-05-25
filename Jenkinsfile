node {
stage("checkout repo"){
git branch: 'master',
credentialsId: 'ad523aab-5236-4c3f-b332-c94fbe5fd5cb',
url: 'https://github.com/bandriychuk/demo-structure.git'
}

stage("build"){
sh "./gradlew api-test:assemble"
}
stage("run api tests"){
sh "./gradlew api-test:test"
}
stage("run ui tests"){
sh "./gradlew ui-test:test"
}

allure([
includeProperties = false,
jdk: '',
properties: [],
reportBuildPolicy: 'ALWAYS',
results: [[path: 'api-test/build/allure-results']]
])

}