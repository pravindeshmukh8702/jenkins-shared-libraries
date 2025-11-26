def call(String credentialsId, String imageName, String imageTag = 'latest') {
    echo "Pushing Docker image to DockerHub: ${imageName}:${imageTag}"
    
    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        usernameVariable: 'DOCKER_USERNAME',
        passwordVariable: 'DOCKER_PASSWORD'
    )]) {
        sh """
            echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
            docker tag ${imageName}:${imageTag} \$DOCKER_USERNAME/${imageName}:${imageTag}
            docker push \$DOCKER_USERNAME/${imageName}:${imageTag}
        """
    }
}
