
// git SSH 凭证
def git_auth = "55b98a6e-afc4-40fc-8999-2482b0ee5f1b"
// git url地址
def git_url = "git@github.com:cupxu/git-test.git"
// 镜像版本号
def tag = "latest"
// harbor地址
def harbor_url = "47.96.190.164:85"

def harbor_project = "git-test"
node{
    stage('拉取代码'){
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
    }

    stage('maven 打包'){
        // dockerfile:build 触发docker build命令
        sh "mvn clean package dockerfile:build"

        // 定义镜像名
        def imageName = "${project_name}:${tag}"

        sh "docker tag ${imageName} ${harbor_url}/${harbor_project}/${imageName}"

    }
}