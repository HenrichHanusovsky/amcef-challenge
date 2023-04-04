if ! ./mvnw install -DskipTests
then
  echo "There was an error during maven install"
  exit 1
fi
docker-compose build app
docker-compose up