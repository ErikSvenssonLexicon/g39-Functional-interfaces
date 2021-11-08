package se.lexicon.g39_functional_interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import se.lexicon.g39_functional_interfaces.app2interfaces.Filter;
import se.lexicon.g39_functional_interfaces.app2interfaces.Action;
import se.lexicon.g39_functional_interfaces.app2interfaces.Mapper;
import se.lexicon.g39_functional_interfaces.model.Person;

public class App2 {
	
	static List<Person> people = new ArrayList<>(Arrays.asList(
				new Person(1, "Erik", "Svensson", LocalDate.parse("1976-09-11")),
				new Person(2, "Erik", "Alfredsson", LocalDate.parse("1986-10-13")),
				new Person(3, "Karmand", "Aziz", LocalDate.parse("1992-04-17")),
				new Person(4, "Basel", "Askar", LocalDate.parse("1987-07-11")),
				new Person(5, "Tony", "Granath", LocalDate.parse("1987-07-12"))
			));
	
	public static void main(String[] args) {
		//find
		Person person = find(people, p -> p.getId() == 2);
		System.out.println(person);
		//findAndDo
		findAndDo(
				people, 
				p -> p.getId() == 1, 
				p -> System.out.println(p.getBirthDate()
			)
		);
		//Find and convert
		String s = findAndConvert(
				people, 
				p -> p.getLastName().equals("Svensson"), 
				p -> p.getFirstName() + " " + p.getLastName()
		);
		System.out.println(s);
		
	}
	
	public static <T> T find(Collection<T> source, Filter<T> predicate) {
		for(T obj : source) {
			if(predicate.test(obj)) {
				return obj;
			}
		}
		return null;
	}
	
	public static <T> void findAndDo(Collection<T> source, Filter<T> predicate, Action<T> consumer) {
		for(T obj : source) {
			if(predicate.test(obj)) {
				consumer.consume(obj);
			}
		}
	}
	
	public static <T,R> R findAndConvert(Collection<T> source, Filter<T> predicate, Mapper<T, R> mapper) {
		for(T t : source) {
			if(predicate.test(t)) {
				return mapper.map(t);
			}
		}
		return null;
	}
	
	

}
