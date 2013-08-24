SET PATHSRC=C:\Users\Bruno\Documents\GitHub\CCompiler\CCompiler\src
:: SET PATHSRC= C:\Users\Matheus\git\CCompiler\CCompiler\src

cd %PATHSRC%

java -jar lib\JFlex.jar %PATHSRC%\flex\C.flex

java -jar lib\java-cup-11a.jar -destdir %PATHSRC%\cup -expect 500 -package cup %PATHSRC%\cup\C.cup

pause