#!/bin/bash

source .env

export MODE="-it --rm"

echo "Testing ${IMAGE} ..."

docker container run ${RUN_OPTS} ${CONTAINER_NAME}-test ${MODE} ${NETWORK} ${PORT_MAP} ${VOL_MAP} ${REGISTRY}${IMAGE}${TAG} sh -c "for t in \$(ls /test*.sh); do echo Running test \$t; \$t; done;" 


