# Description of the computer-science project
This project is a review of Computer Science concepts including examples in Java. It was developed for the purpose of implementing, explaining, and demonstrating some topics and questions from coding interviews. The code is structured into topics and sections within corresponding subdirectories. Internally the project uses Maven and Java to build and test the code. You can choose to execute all tests or just a subset of them, just follow the instructions below.

# Use
This is a [Depend on Docker](https://github.com/bhgedigital/depend-on-docker) project that you can just run using the run.sh or test.sh scripts available in this folder. The only required dependency is [Docker](https://docs.docker.com/install/).

## Interactive use

    ./run.sh bash
    cd /wd/Container-Root
    mvn test

The source code is mounted into the container. You can use any editor to modify the code within the Container-Root folder outside the container, and then run the "mvn test" command inside the container to test it. 
To execute all unit tests, run the "mvn test" command in the /wd/Container-Root folder. To execute a specific test, first cd into the folder of the specific example, then execute the "mvn test" command.

## Noninteractive test

    ./test.sh

Executes tests against all sources that are embedded in the Docker image. If the source code outside the container is changed, the container needs to be rebuilt with the "build.sh" script in order for the changes to be reflected inside the container and used by the "test.sh" script.

When this script is executed for the first time, if the Docker image is not available, it will pull it from [Docker Hub](https://hub.docker.com/r/iankoulski/computer-science).
