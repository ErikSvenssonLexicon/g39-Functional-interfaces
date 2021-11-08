package se.lexicon.g39_functional_interfaces.interfaces;

@FunctionalInterface
public interface DoStringStuff {
	
	/* functional interface is any Interface that...
	 * 1. Has ONLY one abstract method
	 * 
	 * ...Can have any number of default and static methods and so on.
	 * 
	 */
	
	String operate(String s1, String s2);

}
