package se.lexicon.g39_functional_interfaces;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Erik
 * 1. Understanding Functional Interfaces
 * 
 *
 */
public class App 
{
	static DoStringStuff getBiggestString = new DoStringStuff() {

		@Override
		public String operate(String s1, String s2) {
			return s1.length() >= s2.length() ? s1 : s2;
		}
    	
    };
    static StringOperator concatStrings = new StringOperator();
    //                  Argument List     Arrow     Body
    static DoStringStuff concatLambda = (s1, s2) -> s1 + " " + s2;	
    
    //                       Single param ->   Body
    static Action printAction = string -> System.out.println(string);
    
    static IntRandomSupplier supplier = () -> ThreadLocalRandom.current().nextInt();
	
    public static void main( String[] args )
    {        
        String firstName = "Erik";
        String lastName = "Svensson";
        
        
        String result1 = doStringStuff(firstName, lastName, concatLambda);
        String result2 = doStringStuff(firstName, lastName, (s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        String result3 = doStringStuff(firstName, lastName, new DoStringStuff() {

			@Override
			public String operate(String s1, String s2) {
				return s1.toLowerCase() + " " + s2.toLowerCase();
			}
        	
        });
        
        printAction.apply(result1);
        printAction.apply(result2);
        printAction.apply(result3);
        
        Conditional isEven = i -> i % 2 == 0;
        
        
        System.out.println(isEven.testInt(supplier.generate()));
        System.out.println(isEven.testInt(supplier.generate()));
        
    }
    
    public static String doStringStuff(String s1, String s2, DoStringStuff operator) {
    	return operator.operate(s1, s2);
    }
}
