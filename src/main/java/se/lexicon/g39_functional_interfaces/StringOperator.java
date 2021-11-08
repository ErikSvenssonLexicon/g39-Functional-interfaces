package se.lexicon.g39_functional_interfaces;

public class StringOperator implements DoStringStuff{

	@Override
	public String operate(String s1, String s2) {
		return s1.concat(s2);
	}

}
