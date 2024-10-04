javac --source-path . ./*.java people/*.java service/*.java -d target
java -cp target App

//Go into target folder (jar packaging)
jar -c -v -f day03.jar -e App.