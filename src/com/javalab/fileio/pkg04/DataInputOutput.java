package com.javalab.fileio.pkg04;

import java.io.*;

/**
 * DataOutputStream
 *  - 기본형 데이터를 좀더 편리하게 읽고 쓸수 있습니다.
 */
public class DataInputOutput {
	public static void main(String[] args) throws Exception {
		//File 객체 생성
		File file = new File("C:/filetest/primitive.db");
		// FileOutputStream 생성
		FileOutputStream fos = new FileOutputStream(file);
		//DataOutputStream 생성	// FileOutputStream을 기반으로 기본형 자료를 좀더 편리하게 읽고/쓰기 위함.
		DataOutputStream dos = new DataOutputStream(fos);
		
		//기본 타입 출력
		dos.writeUTF("홍길동");	// UTF-8 형식으로 인코딩하여 문자열 출력
		dos.writeDouble(95.5);
		dos.writeInt(1);
		
		dos.writeUTF("감자바");
		dos.writeDouble(90.3);
		dos.writeInt(2);
		
		dos.flush();	// 잔류되있던 데이터 남김없이 빼기
		dos.close();
		fos.close();

		//DataInputStream 생성
		FileInputStream fis = new FileInputStream("C:/filetest/primitive.db");
		DataInputStream dis = new DataInputStream(fis);
		
		//기본 타입 출력
		for (int i = 0; i < 2; i++) {
			String name = dis.readUTF();	//UTF-8 형식으로 코딩된 문자열을 받는다.
			double score = dis.readDouble();	//double type 읽기
			int order = dis.readInt();	//	int type 읽기
			System.out.println(name+ " : " + score + " : " + order);
		}
		
		dis.close();
		fis.close();
	}
}
