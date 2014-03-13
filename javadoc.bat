@echo off
echo [CMMI] Production Facade stage Interface API documentation.
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

echo [Step 1]  Into Facade stage path.
cd cmmi-modules\cmmi-common\cmmi-common-service

call %MVN% clean javadoc:aggregate

goto end 

:end
pause