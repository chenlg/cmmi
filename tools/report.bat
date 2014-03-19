@echo off
echo [CMMI] report check.
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

cd ..
call %MVN% clean site site:stage

goto end 

:end
pause