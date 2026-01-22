.PHONY: build run-standalone run-mariadb clean

GRADLEW=./gradlew
APP_MODULE=:file-telemetry-api

build:
	$(GRADLEW) clean build

run-standalone:
	SPRING_PROFILES_ACTIVE=standalone \
	$(GRADLEW) $(APP_MODULE):bootRun

run-mariadb:
	SPRING_PROFILES_ACTIVE=mariadb \
	$(GRADLEW) $(APP_MODULE):bootRun

clean:
	$(GRADLEW) clean
