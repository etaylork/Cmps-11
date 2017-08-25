#-----------------------------------------
#Elijah Taylor-Kuni
#Makefile pa5
#cmps 11
#-----------------------------------------

Complex: Complex.class
	echo Main-class: Complex > Manifest
	jar cvfm Complex Manifest Complex.class
	rm Manifest 
	chmod u+x Complex
	
Complex.class: Complex.java
	javac -Xlint Complex.java 

clean: 
	rm -f Complex.class Complex.

submit: Makefile Complex.java
	submit cmps011-pt.s14 pa5 Makefile Complex.java
