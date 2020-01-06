package com.bolbas.app.map;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo4 {

	public static void main(String[] args) {
		//список числовых значений типа double
		ArrayList<Double> myList = new ArrayList<>();
		
		myList.add(7.0);
		myList.add(18.0);
		myList.add(10.0);
		myList.add(24.0);
		myList.add(17.0);
		myList.add(5.0);
		
		//Отобразить квадратные корни элементов из списка myList
		//на новый поток данных
		
		Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a));
		
		//sqrtRootStrm.forEach(a -> System.out.println(a));
		
		//Получить произведение квадратных корней
		Optional<Double> productsOfSqrRoots = sqrtRootStrm.reduce((a, b) -> a * b);
		
		System.out.println("Произведение квадратных корней равно " + productsOfSqrRoots.get());
	}

}
