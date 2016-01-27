Teamname=Grouptwo
all: 
	javac -cp Cram.jar algorithms/$(Teamname).java;
	java -cp Cram.jar:. algorithms.$(Teamname)
