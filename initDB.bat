@echo off
echo [CMMI] Production Facade stage Interface API documentation.
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m 

cd cmmi-modules\cmmi-core\cmmi-core-persistant\cmmi-core-persistant-repository
call %MVN% antrun:run -Prefresh-db

goto end 

:end
pause