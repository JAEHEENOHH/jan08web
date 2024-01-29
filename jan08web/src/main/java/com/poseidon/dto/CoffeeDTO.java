package com.poseidon.dto;

public class CoffeeDTO {
 private int no;
 private String coffee_name, tea_name, person;
 
public String getPerson() {
	return person;
}
public void setPerson(String person) {
	this.person = person;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getCoffee_name() {
	return coffee_name;
}
public void setCoffee_name(String coffee_name) {
	this.coffee_name = coffee_name;
}
public String getTea_name() {
	return tea_name;
}
public void setTea_name(String tea_name) {
	this.tea_name = tea_name;
 }
}