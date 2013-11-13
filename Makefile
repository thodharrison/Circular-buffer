all: main Consumer Producer buffer
	
main: main.java
	javac main.java
	
Consumer: Consumer.java
	javac Consumer.java
	
Producer: Producer.java
	javac Producer.java
	
buffer: buffer.java
	javac buffer.java
	
clean:
	rm *.class

