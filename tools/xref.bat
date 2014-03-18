@echo off
echo [CMMI] Production Facade stage Interface API documentation.
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

echo [Step 1]  Into Facade stage path.
cd .. 

call %MVN% clean javadoc:aggregate -Prefresh-javadoc

call %MVN% jxr:jxr -Prefresh-javadoc


goto end 

:end
pause