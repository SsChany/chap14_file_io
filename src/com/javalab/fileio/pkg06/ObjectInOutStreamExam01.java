package com.javalab.fileio.pkg06;

import java.io.*;

/*
 * ObjectOutputSTream
 *  - 개발자가 만든 클래스의 인스턴스(객체)를 파일에 저장함.
 */						//껍질메소드
class Person implements Serializable{ //Person start
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}	// Person end

public class ObjectInOutStreamExam01 {
	
	public static void main(String[] args) {	// main start
		//파일에 저장할 Person 객체 생성
		Person person = new Person("John Doe", 30); 
		File file = null;
		
		try {
			//파일 객체 생성
			file = new File("C:/filetest/object2.txt");
			
			//객체를 파일에 쓸 FileOutputStream 객체 생성
			FileOutputStream fos = new FileOutputStream(file);
			
			//FileOutputStream 에 보조스트림인 ObjectOutputStream 연결
			ObjectOutputStream objOut = new ObjectOutputStream(fos);
			
			//객체를 파일에 씀
			objOut.writeObject(person);
			objOut.close();

			System.out.println("객체가 정상적으로 파일에 써졌습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2. 파일에서 객체 읽어들이기
		try {
			FileInputStream fileIn = new FileInputStream(file);//1byte로 읽어온다
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
			// Object() 메소드의 반환타입이 Object이기 때문에 형변환
			Person savedPerson = (Person) objectIn.readObject();	//object에는 뭐 없어서 강제 형변환 해야됨
			objectIn.close();

			System.out.println("객체를 파일에서 읽어들임");
			System.out.println(savedPerson);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
