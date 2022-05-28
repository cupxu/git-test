
// git SSH 凭证
def git_auth = "55b98a6e-afc4-40fc-8999-2482b0ee5f1b"
// git url地址
def git_url = "git@github.com:cupxu/git-test.git"
// 镜像版本号
def tag = "latest"
// harbor地址
def harbor_url = "47.96.190.164:85"
// harbor项目名
def harbor_project_name = "git-test"
// harbor 登录凭证
def harbor_auth = "8d1dd335-c4e9-4ce4-bf4e-48df3c61d338"
node{
    stage('拉取代码'){
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
    }

    stage('maven 打包'){
        // dockerfile:build 触发docker build命令
        sh "mvn clean package dockerfile:build"

        // 定义镜像名
        def imageName = "${harbor_project_name}:${tag}"

        sh "docker tag ${imageName} ${harbor_url}/${harbor_project_name}/${imageName}"

        //登录Harbor，并上传镜像
        withCredentials([usernamePassword(credentialsId: "${harbor_auth}",
        passwordVariable: 'password', usernameVariable: 'username')]) {
        //登录
        sh "docker login -u ${username} -p ${password} ${harbor_url}"
        //上传镜像
        sh "docker push ${harbor_url}/${harbor_project_name}/${imageName}"
        }

        //删除本地镜像
        sh "docker rmi -f ${imageName}"
        sh "docker rmi -f ${harbor_url}/${harbor_project_name}/${imageName}"

        //=====以下为远程调用进行项目部署========
        // 编写deploy.sh部署脚本
        sshPublisher(publishers: [sshPublisherDesc(configName: 'tx-server', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "/opt/jenkins_shell/deploy.sh $harbor_url $harbor_project_name $project_name $tag $port", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
    }
}