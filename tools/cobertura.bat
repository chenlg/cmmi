@echo off
echo [CMMI] cobertura check.
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m 

echo [Step 1]  Into path. 
cd ..
cd cmmi-modules

call %MVN% clean cobertura:cobertura -Prefresh-cobertura

goto end 

:end
pause