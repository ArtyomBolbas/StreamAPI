package com.bolbas.app.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmail {
	private String name;
	private String phoneNum;
	private String email;
	
	public NamePhoneEmail(String name, String phoneNum, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

class NamePhone {
	private String name;
	private String phoneNum;
	
	public NamePhone(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}

public class StreamDemo7 {

	public static void main(String[] args) {
		// Список имен, номеров телефонов и адресов электронной почты
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Merry", "555-3333", "Merry@HerbSchildt.com"));
		
		//отобразить только имена и номера телефонов на новый поток данных
		Stream<NamePhone> nameAndPhone = myList.stream()
											.map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
		
		//вызвать метод collect(), чтобы составить список типо List
		//из имен и номера телефонов
		List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
		
		System.out.println("Имена и номера телефонов в списке типа List: ");
		for (NamePhone e: npList)
			System.out.println(e.getName() + ": " + e.getPhoneNum());
		
		//получить другое отображение имен и номеров телефонов
		nameAndPhone = myList.stream()
						.map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
		
		//а теперь создать множество типа Set, вызваа метод collect()
		Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
		
		System.out.println("\nНомера телефонов в множестве типа Set:");
		for (NamePhone e: npSet)
			System.out.println(e.getName() + ": " + e.getPhoneNum());
		
		
		//***************************************************************
		//получить другое отображение имен и номеров телефонов для LinkedList
		nameAndPhone = myList.stream()
						.map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
		
		LinkedList<NamePhone> npLinkedList = nameAndPhone.collect(
				() -> new LinkedList<>(),
				(list, element) -> list.addFirst(element),
				(listA, listB) -> listA.addAll(listB));
		
		System.out.println("\nИмена и номера телефонов в списке типа LinkedList: ");
		for (NamePhone e: npLinkedList)
			System.out.println(e.getName() + ": " + e.getPhoneNum());
		
		
		//***************************************************************
		//получить другое отображение имен и номеров телефонов для HashSet
		nameAndPhone = myList.stream()
						.map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
		
		HashSet<NamePhone> npHashSetList = nameAndPhone.collect(HashSet::new,
							 HashSet::add,
							 HashSet::addAll);
		
		System.out.println("\nИмена и номера телефонов в списке типа HashSet: ");
		for (NamePhone e: npHashSetList)
			System.out.println(e.getName() + ": " + e.getPhoneNum());
	}

}
