package com.bolbas.app.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo8 {

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

        //получить итератор лоя потока данных
        Iterator<String> itr = myStream.iterator();
        
        //перебрать эл-ты в потоке данных
        while(itr.hasNext())
        	System.out.println(itr.next());
	}

}
