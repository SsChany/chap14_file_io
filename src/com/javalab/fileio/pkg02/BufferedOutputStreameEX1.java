package com.javalab.fileio.pkg02;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 보조스트림
 *  - FileOutputStream의 성능 향상을 위한 보조적인 스트림
 *  - BufferedOutputStream : 하드디스크에 쓰지 않고 메모리 버퍼에 씀,
 *    버퍼에 일정 부분 데이터가 쌓이면 한꺼번에 하드디스크에 저장하므로 속도가 아주 빠름.
 */
public class BufferedOutputStreameEX1 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;	//보조적인겨
		try {
			File file = new File("c:filetest/test5.txt");	//어디다쓸거인지
			fos = new FileOutputStream(file);	//FileOutputStream이 만들어졌어
			
			// FileOutputStream을 생성자로 받는다.
			// BufferedOutputStream의 버퍼 크기를 5로 한다.
			bos = new BufferedOutputStream(fos,25);
			
			// 파일 test5.txt에 1부터 9까지 출력한다
			for (int i = 'a'; i <= 'z'; i++) {
				bos.write(i);
			}
			
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
