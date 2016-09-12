compile:
	find out -name ".class" -delete
	javac -cp src/ -d out/ **/*.java
run:
	java -cp ./out Main
