package org.acme.model;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlType;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "Response", propOrder = { "response", "name", "dutchResponse", "frenchResponse" })
public class HelloResponse {

	private String greeting;

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "response")
	public String getResponse() {
		return greeting + " " + name;
	}

	@XmlElement(name = "frenchResponse")
	public String getOtherResponseSecond() {
		return "Salut " + name;
	}

	@XmlElement(name = "dutchResponse")
	public String getOtherResponseFirst() {
		return "Hallo " + name;
	}

	/**
	 * @return the greeting
	 */
	public String getGreeting() {
		return greeting;
	}

	/**
	 * @param greeting the greeting to set
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
