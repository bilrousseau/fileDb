package com.m2i.filedbee.beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class User {
	private String firstname;
	private String lastname;
	private String birthDate;
	private String email;
	private HashMap<String, String> errors;
	
	public User() {
		this.errors = new HashMap<String, String>();
	}
	
	private User(String firstname, String lastname, String birthDate, String email, HashMap<String, String> errors) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.email = email;
		this.errors = errors;
	}
	
	public void writeToFile(String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
			bw.write(this.toString());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User getByName(String filePath, String name) {
		BufferedReader br = null;
		String line = null;
		User foundUser = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			
			while (br.ready()) {
				line = br.readLine();
				String[] arrayLine = line.split(";");
				if (name.equals(arrayLine[0])) {
					foundUser = new User();
					foundUser.setLastname(arrayLine[0]);
					foundUser.setFirstname(arrayLine[1]);
					foundUser.setBirthDate(arrayLine[2]);
					foundUser.setEmail(arrayLine[3]);
					
					break ;
				}
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundUser;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		if (firstname.length() > 0) {
			if (firstname.matches("(?i)[a-z]{2,60}")) {
				this.firstname = firstname;
			} else {
				this.firstname = null;
				this.addError("error_firstname", "Le prénom ne peut contenir que des lettres (de 2 à 50");
			}
		} else {
			this.firstname = null;
			this.addError("error_firstname", "Veuillez renseigner le prénom");
		}
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		if (lastname.length() > 0) {
			if (lastname.matches("(?i)[a-z]{2,60}")) {
				this.lastname = lastname;
			} else {
				this.lastname = null;
				this.addError("error_lastname", "Le nom ne peut contenir que des lettres (de 2 à 50");
			}
		} else {
			this.lastname = null;
			this.addError("error_lastname", "Veuillez renseigner le nom");
		}
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		if (birthDate.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
			Integer day = Integer.parseInt(birthDate.substring(0, 2));
			Integer month = Integer.parseInt(birthDate.substring(3, 5));
			Integer year = Integer.parseInt(birthDate.substring(6, 10));
			System.out.println(day);
			System.out.println(month);
			System.out.println(year);
			this.birthDate = birthDate;
		} else {
			this.birthDate = null;
			this.addError("error_birthdate", "Veuillez entrer une date valide au format JJ-MM-AAAA");
		}
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		//TODO: penser à trouver une regex potable pour les adresses e-mail...
	}

	public HashMap<String, String> getErrors() {
		return errors;
	}

	public void addError(String errorName, String errorMessage) {
		this.errors.put(errorName, errorMessage);
	}
	
	public void removeError(String errorName) {
		this.errors.remove(errorName);
	}
	
	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}
	
	public String toString() {
		return this.getFirstname()+";"+this.getLastname()+";"+this.getBirthDate()+";"+this.getEmail();
	}
	
	
}
