package se.lexicon.g39_functional_interfaces.implementations;

import se.lexicon.g39_functional_interfaces.interfaces.DoStringStuff;

public class StringOperator implements DoStringStuff{

	@Override
	public String operate(String s1, String s2) {
		return s1.concat(s2);
	}

}
