#! /bin/sh

case $1 in
	java) 
		APP_CLASS=app.SpringJavaConfigMessageEmitter
		;;
	xml) 
		APP_CLASS=app.SpringXmlConfigMessageEmitter
		;;
	*)
		APP_CLASS=app.DIMessageEmitter
		;;
esac

mvn clean compile exec:java -Dexec.mainClass=${APP_CLASS}
