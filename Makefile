SHELL = /bin/bash

IMAGE = sandrogiacom/password-check

# Rule "build"
.PHONY: build
build: ## Build the Dockerfile
	mvn clean install
	docker build --force-rm --no-cache -t $(IMAGE) .

# Rule "push"
.PHONY: push
push: ## Push image to docker hub
	docker push $(IMAGE)
