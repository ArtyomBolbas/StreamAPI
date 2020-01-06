package com.bolbas.app.spliterator;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

//Продемонстрировать применение метода trySplit()
public class StreamDemo10 {

	public static void main(String[] args) {
		// создать список символьных строк
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Alpha");
		myList.add("Beta");
		myList.add("Gamma");
		myList.add("Delta");
		myList.add("Xi");
		myList.add("Omega");

		// получить поток данных для списочного массива
		Stream<String> myStream = myList.stream();
		
		//получить итератор-разделитель
		Spliterator<String> splitItr = myStream.spliterator();
		
		//а теперь разделить первый итератор
		Spliterator<String> splitItr2 = splitItr.trySplit();
		
		//использовать сначала итератор splitItr2, если
		//нельзя разделить итератор splitItr
		if (splitItr2 != null) {
			System.out.println("Результат выводимый итератором splitItr2: ");
			splitItr2.forEachRemaining(n -> System.out.println(n));
		}
		
		System.out.println("\nРезультат, выводимый итератором splitItr");
		splitItr.forEachRemaining(n -> System.out.println(n));
	}

}
