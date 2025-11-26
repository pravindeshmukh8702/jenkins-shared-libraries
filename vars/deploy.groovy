def call(){
  echo "deployment started.."
  sh "docker-compose down && docker-compose up -d"

}
