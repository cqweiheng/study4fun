package com.study01;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class Stream003Collect2Map {

	public static Stream<Person> people(){
		return Stream.of(new Child("1001", "Peter"),
			new Child("1002", "Paul"), new Child("1003", "Mary"));
	}

	public static void main(String[] args) throws IOException {
		Map<String, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
		System.out.println("idToName:" + idToName);

		Map<String, Person> idToPerson =
				people().collect(Collectors.toMap(Person::getId, Function.identity()));
		System.out.println("idToPerson:" + idToPerson.getClass().getName() + idToPerson);

		idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()
					, (existingValue, newValue) -> {throw new IllegalStateException();}, TreeMap::new));
		System.out.println("idToPerson:" + idToPerson.getClass().getName() + idToPerson);

		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<String, String> languageNames = locales.collect(Collectors.toMap(Locale::getDisplayLanguage, l -> l.getDisplayLanguage(l),
			(existingValue, newValue) -> existingValue));
		System.out.println("languageNames:" + languageNames);

		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Set<String>> countryLanguageSets = locales.collect(Collectors.toMap(Locale::getDisplayCountry
			, l -> Collections.singleton(l.getDisplayLanguage()),
			(a, b) -> {
				Set<String> union = new HashSet<>();
				union.addAll(b);
				return union;
			}));
		System.out.println("countryLanguageSets:" + countryLanguageSets);

		locales = Stream.of(Locale.getAvailableLocales());

//		locales.collect(BitSet::new, BitSet::set, BitSet::or);
		Map<String, Long> collect
			= locales.collect(Collectors.groupingBy(Locale::getCountry, counting()));
		System.out.println("collect:" + collect);

//		Files.lines(Path.of("")).map(l -> l.split(","));

		List<Person> persons = Stream.of(new Child("1001", "Peter"),
			new Child("1002", "Paul"), new Child("1003", "Mary"), new Child("1003", "Maryan")
			, new Child("1003", "Maryrish"), new Child("1003", "Marysdfs"), new Child("1003", "Mary")
			).collect(toList());
		System.out.println("persons:" + persons);
		persons.sort(Comparator.comparing(Person::getId).thenComparing((x,y)->{
															if(x.getName().length() > y.getName().length()){
																return 1;
															} else {return -1;}
														})
		);
		System.out.println("persons2:" + persons);




//		Function<Integer, Integer> function = i -> i+1;
//		System.out.println(function.apply(5));
	}
}
