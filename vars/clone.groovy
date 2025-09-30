def call(String url, String branch){
  echo "this is code cloning stage"
  git url: "${url}", branch: "${branch}"
  echo "code cloning successfull.."
}
