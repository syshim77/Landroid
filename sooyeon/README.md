# Git Usage
If you want to Update git repo with collaborators, please follow this instruction.  
This instruction is only using master branch.  

## Connect local & remote
1. Repo owner
  ```
  git init
  git add .
  git commit -m "first commit"
  git remote add origin url
  git push -u origin master
  ```
2. Collaborators
  ```
  git clone url
  git pull
  ```

## After Connection
Cannot push, local and remote is not same.  

1. Local & Remote is same
  ```
  git add directory_or_file_name or .
  git commit -m "commit contents"
  git push origin master
  ```
2. Local & Remote is not same
  ```
  git pull
  git add directory_or_file_name or .
  git commit -m "commit contents"
  git push origin master
  ```
