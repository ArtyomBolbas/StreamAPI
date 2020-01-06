package com.bolbas.app.map;

import java.util.ArrayList;
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

public class StreamDemo5 {

	public static void main(String[] args) {
		
		//Список имен, номеров телефонов и адресов электронной почты
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Merry", "555-3333", "Merry@HerbSchildt.com"));
		
		System.out.println("Исходные эл-ты из списка myList: ");
		myList.stream().forEach(a -> System.out.println(a.getName() + " " + a.getPhoneNum() + " " + a.getEmail()));
		System.out.println();
		
		//отобразить на новый поток данных
		//только номера и имена телефонов
		Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
		
		System.out.println("Список имен и номеров телефонов: ");
		nameAndPhone.forEach(a -> System.out.println(a.getName() + " " + a.getPhoneNum()));
		System.out.println();
		
		Stream<NamePhone> nameAndPhoneFavorite = myList.stream()
											.filter(a -> a.getName().equals("James"))
											.map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
		nameAndPhoneFavorite.forEach(a -> System.out.println("Полученный объект: " + a.getName() + " " + a.getPhoneNum()));
	}

}
