def call () {
    GIT_SRC    = sh encoding: 'UTF-8', label: 'GetGitSrc', returnStdout: true, script: 'git config --get remote.origin.url'
    return GIT_SRC.trim()
}