package com.biz.ems.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class NaverSecMake {
	public static void main(String[] args) {
		
		// 암호화된 네이버 email정보를 저장할 파일
		String propsFile = "./src/main/webapp/WEB-INF/spring/naver.sec.properties";
		
		// 암호화를 수행할 때 사용할 salt 추출
		Map<String, String> envList = System.getenv(); // 환경변수 리스트 가져오기
		String saltPass = envList.get("NAVER");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Salt Password : " + saltPass);
		
		if(saltPass == null) {
			System.out.println("NAVER 환경변수를 설정한 후 실행해주세요");
			return;
		}
		
		// 암호화할 문자열 입력받기
		System.out.print("Email 주소 : ");
		String email = scan.nextLine();
		System.out.print("비밀번호 : ");
		String password = scan.nextLine();
		
		// 암호화
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		pbe.setAlgorithm("PBEWithMD5AndDES");
		pbe.setPassword(saltPass);
		
		String encEmail = pbe.encrypt(email);
		String encPass = pbe.encrypt(password);
		
		String props_email = String.format("naver.email=ENC(%s)", encEmail);
		String props_password = String.format("naver.password=ENC(%s)", encPass);
		
		System.out.println("Email: " + props_email);
		System.out.println("Pass: " + props_password);
		
		try {
			PrintWriter out = new PrintWriter(propsFile);
			out.println(props_email);
			out.println(props_password);
			out.flush();
			out.close();
			
			System.out.println("설정파일 저장완료:)");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
