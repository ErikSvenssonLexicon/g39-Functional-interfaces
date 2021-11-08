package se.lexicon.g39_functional_interfaces.app2interfaces;

public interface Action<T> {
	
	void consume(T obj);

}
