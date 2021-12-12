package com.springboot.projectweb.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*Generar Password para consumir de la base de datos Directo*/
public class EncryptPassword {

	public static void main(String[] args) {
		String pass = "user123";
		System.out.println(pass);
		System.out.println(encryptPass(pass));

	}

	public static String encryptPass(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);

	}

}
