def call(chartName, chartVersion, repoUrl, repoCredentialsId, helmFolder ='helm/', containerName = 'helm') {
    container("${containerName}") {
        // TODO: do something with helm lint errors
        withCredentials([usernameColonPassword(credentialsId: repoCredentialsId, variable: 'CREDS')]) {
            sh """helm lint ${helmFolder}${chartName}
            helm package ${helmFolder}${chartName}
            curl --insecure -u ${CREDS} --data-binary \"@${chartName}-${chartVersion}.tgz\" ${repoUrl}/api/charts
            """
        }
    }
}