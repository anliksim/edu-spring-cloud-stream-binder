# Spring Cloud Stream

Education series - spring cloud stream with rabbitmq.


## Usage

Start up rabbitmq on port `5672` using docker.

	sudo docker run -d --hostname my-rabbit --name some-rabbit -p 9090:15672 -p 5672:5672 rabbitmq:3-management


Run `edu.cloud.stream.NameProcessorApplication` and `edu.cloud.stream.NameSinkApplication` in your IDE.


To test the apps submit a message to the `inName` destination using the management UI on `localhost:9090`.


