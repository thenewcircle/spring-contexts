REM @ECHO OFF


2>NUL CALL :CASE_%1R% # jump to :CASE_command line arg for java or xml
IF ERRORLEVEL 1 CALL :DEFAULT_CASE # if label doesn't exist

ECHO Done.
EXIT /B

:CASE_java
  set APP_CLASS=app.SpringJavaConfigMessageEmitter
  GOTO END_CASE
:CASE_blue
  set APP_CLASS=app.SpringXMLConfigMessageEmitter
  GOTO END_CASE
:DEFAULT_CASE
  set APP_CLASS=app.DIMessageEmitter
  GOTO END_CASE
:END_CASE
	mvn clean compile exec:java -Dexec.mainClass=%APP_CLASS% 
