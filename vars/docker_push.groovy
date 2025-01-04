def call(String image,String tag){
  withCredentials([usernamePassword('credentialsId': "dockerHub-token",'usernameVariable': "dockerHubUser",'passwordVariable': "dockerHubPassword")]){
    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
    sh "docker tag ${image}:${tag} ${env.dockerHubUser}/${image}:${tag}"
    sh "docker push ${env.dockerHubUser}/${image}:${tag}"
  }
}
