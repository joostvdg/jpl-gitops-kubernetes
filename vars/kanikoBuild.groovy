def call(dockerfile, destination, containerName = 'kaniko') {
    container(name: containerName, shell: '/busybox/sh') {
        withEnv(['PATH+EXTRA=/busybox', "FILE=${dockerfile}", "DEST=${destination}"]) {
            sh '''#!/busybox/sh
                /kaniko/executor --cleanup -f `pwd`/${FILE} -c `pwd` --insecure-skip-tls-verify --cache=true --destination=${DEST}
            '''
        }
    }
}