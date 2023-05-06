kubectl delete deployment agl-news-adapter -n agl-dev

kubectl delete service agl-news-adapter -n agl-dev

./gradlew clean build

docker build . -t agl-news-adapter

kubectl create -f ./k8s -n agl-dev