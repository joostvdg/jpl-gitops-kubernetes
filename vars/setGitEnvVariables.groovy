def call () {
    GIT_COMMIT = sh encoding: 'UTF-8', label: 'GetGitCommit', returnStdout: true, script: 'git rev-parse HEAD'
    GIT_SRC    = sh encoding: 'UTF-8', label: 'GetGitSrc', returnStdout: true, script: 'git config --get remote.origin.url'
}