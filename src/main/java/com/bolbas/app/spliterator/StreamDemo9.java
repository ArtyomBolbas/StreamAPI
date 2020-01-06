package com.bolbas.app.spliterator;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {

	public static void main(String[] args) {
		// создать список символьных строк
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Xi");
        myList.add("Omega");
        
        //получить поток данных для списочного массива
        Stream<String> myStream = myList.stream();
        
        //получить итератор-разделитель
        Spliterator<String> splitItr = myStream.spliterator();

        //перебрать эл-ты в потоке данных
        while (splitItr.tryAdvance(n -> System.out.println(n)));
        System.out.println();
        
        splitItr.forEachRemaining(n -> System.out.println(n));
        
        
	}

}
