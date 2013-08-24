SET PATHSRC= C:\Users\Bruno\Documents\GitHub\CCompiler\CCompiler\src
:: SET PATHSRC= C:\Users\Matheus\git\CCompiler\CCompiler\src


cd %PATHSRC%

java -jar lib\java-cup-11a.jar -destdir %PATHSRC%\cup -package cup -expect 2300 %PATHSRC%\cup\C.cup

pause