# git-test
## git 环境配置

​	git config --global user.name "cupxu"
​	git config --global user.email "1706010425@hhu.edu.cn"
​	查看配置信息
​	git config -l

## 经验知识

每次commit，Git都把它们串成一条时间线，这条时间线就是一个branch,master是主分支
origin是远程主机，master表示是远程服务器上的master分支
	tag 			用于标记某次commit
	branch 			记录一些列的commit
	commit 			将暂存区里的改动给提交到本地的版本库
	fetch是 			将远程主机的最新内容拉到本地，不进行合并
	pull  			将远程主机的master分支最新内容拉下来后与当前本地分支直接合并
	head 			任何时候，HEAD所指向的分支就是当前分支，代表最新的commit
	push 			将本地版本库推送到远程服务器
	merge & rebase 	merge保留了更多的历史信息，而rebase保证只有一条时间线
	fork			fork别人的远程仓库
	watch			跟踪别人的远程仓库，会接收到有关此仓库的变化
	pull request	向别人提交自己的代码
	

## 常用命令

​	git clone、git push、git add 、git commit、git checkout、git pull
​	

## 常用知识

分区
workspace：工作区
staging area：暂存区/缓存区
local repository：版本库或本地仓库
remote repository：远程仓库

主分支

master分支：存放随时可供生产环境中的部署的代码
develop分支：存放当前最新开发成果的分支，当代码足够稳定时可以合并到master分支上去。
辅助分支
feature分支：开发新功能使用，最终合并到develop分支或抛弃掉
release分支：做小的缺陷修正、准备发布版本所需的各项说明信息
hotfix分支：代码的紧急修复工作

## bug

​	删除一个分支前要切换到另一个分支
