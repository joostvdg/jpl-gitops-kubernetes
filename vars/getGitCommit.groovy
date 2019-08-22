def call () {
    GIT_COMMIT = sh encoding: 'UTF-8', label: 'GetGitCommit', returnStdout: true, script: 'git rev-parse HEAD'
    return GIT_COMMIT.trim()
}