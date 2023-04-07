package com.javalab.fileio.pkg03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * 문자 입출력 FileReader, BufferedReader 클래스
 *  - 문자를 2byte씩 읽어들임
 */
public class BufferedReaderEX1 {

		public static void main(String[] args) {
			
			try {
				File file = new File("c:/filetest/123.txt");	//절대경로(c:나 d:로 시작하는것들, 탐색기에서 쓰는것들)	//파일객체 생성 
				FileReader fr = new FileReader(file);	//일단 파일리더한테 줘야됨
				BufferedReader br = new BufferedReader(fr);	//성능을 올리기위해서 버퍼드리더한테 한번더줌
				/*
				String line = "";
				for (int i = 1;(line = br.readLine())!=null; i++) {
					System.out.println(i+":"+line);
				}
				*/
				int lineNo = 1;
				while (true) {
					String str = br.readLine();	//한 행을 읽어들임
					if(str == null) break;	//while문을 빠져나감
					System.out.println(lineNo + "\t" + str);
					lineNo++;
					
				}
				
				br.close();	// 걍 썼지만 원래는 파이널리 구문안에 들어가야함
			} catch (IOException e) {}
		}	// main
}
