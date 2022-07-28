package com.group1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "123456";
		String encodePassword= encoder.encode(rawPassword);
		
		System.out.print(encodePassword);

	}

}
