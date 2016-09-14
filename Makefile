.PHONY: server client

run: server/target/server-1.0.0-SNAPSHOT-fat.jar client/target/client-1.0.0-SNAPSHOT-fat.jar
	make server &
	sleep 10
	make client

server: server/target/server-1.0.0-SNAPSHOT-fat.jar
	java -jar server/target/server-1.0.0-SNAPSHOT-fat.jar

client: client/target/client-1.0.0-SNAPSHOT-fat.jar
	java -jar client/target/client-1.0.0-SNAPSHOT-fat.jar

client/target/client-1.0.0-SNAPSHOT-fat.jar server/target/server-1.0.0-SNAPSHOT-fat.jar:
	mvn package

package:
	mvn package
