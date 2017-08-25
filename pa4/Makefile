# A simple makefile for the Roots.java program 
Roots: Roots.class
	echo Main-class: Roots > Manifest 
	jar cvfm Roots Manifest Roots.class
	rm Manifest
	chmod u+x Roots 

Roots.class: Roots.java
	javac -Xlint Roots.java 

clean: 
	rm -f Roots.class Roots