def call(chartName, chartVersion, repoUrl, repoCredentialsId, containerName = 'helm') {
    container("${containerName}") {
        // TODO: do something with helm lint errors
        withCredentials([usernameColonPassword(credentialsId: repoCredentialsId, variable: 'CREDS')]) {
            sh """helm lint helm/cat-nip
            helm package helm/cat-nip
            curl --insecure -u ${CREDS} --data-binary \"@${chartName}-${chartVersion}.tgz\" ${repoUrl}/api/charts
            """
        }
    }
}