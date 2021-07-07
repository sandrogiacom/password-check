FROM openjdk:11.0.6-jre-slim

ENV APP_HOME "/opt/sandrogiacom/"

# define workdir
WORKDIR ${APP_HOME}

# install necessary packages
RUN set -ex && \
   apt-get update && \
   apt-get install -y curl --no-install-recommends

RUN set -ex && \
   apt-get -y autoremove && \
   apt-get -y autoclean

# add our user and group
# create APP_HOME and change permission
RUN groupadd -r sandrogiacom && useradd -r -g sandrogiacom sandrogiacom && \
   mkdir -p "${APP_HOME}" && chown -R sandrogiacom:sandrogiacom "${APP_HOME}"

# install and configure as user
USER sandrogiacom

# copy artifacts to docker image
ADD --chown=sandrogiacom:sandrogiacom target/password-check.jar "${APP_HOME}"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar password-check.jar" ]
