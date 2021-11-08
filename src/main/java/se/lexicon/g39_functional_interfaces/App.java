package se.lexicon.g39_functional_interfaces;

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
	
    public static void main( String[] args )
    {        
        String firstName = "Erik";
        String lastName = "Svensson";
        //                               Argument List     Arrow     Body
        DoStringStuff concatLambda = (String s1, String s2) -> s1.concat(s2);		
        		
        String result1 = doStringStuff(firstName, lastName, concatLambda);
        String result2 = doStringStuff(firstName, lastName, getBiggestString);
        String result3 = doStringStuff(firstName, lastName, new DoStringStuff() {

			@Override
			public String operate(String s1, String s2) {
				return s1.toLowerCase() + " " + s2.toLowerCase();
			}
        	
        });
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        
    }
    
    public static String doStringStuff(String s1, String s2, DoStringStuff operator) {
    	return operator.operate(s1, s2);
    }
}
