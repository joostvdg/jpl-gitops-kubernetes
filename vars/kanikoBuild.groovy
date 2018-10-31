def call(dockerfile, destination, params = '', containerName = 'kaniko') {
    container(name: containerName, shell: '/busybox/sh') {
        withEnv(['PATH+EXTRA=/busybox', "FILE=${dockerfile}", "DEST=${destination}", "PARAMS=$params"]) {
            sh '''#!/busybox/sh
                /kaniko/executor --cleanup -f `pwd`/${FILE} -c `pwd` --cache=true --destination=${DEST} ${PARAMS}
            '''
        }
    }
}