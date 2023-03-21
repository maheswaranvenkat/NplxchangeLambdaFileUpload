package com.nplxhange.aws.lambda.function;

public class NplxchangeCheckoutEvent {

	public String firstName;
	public String middleName;
	public String lastName;
	public String ssn;

	public NplxchangeCheckoutEvent() {

	}

	public NplxchangeCheckoutEvent(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "NplxchangeCheckoutEvent [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", ssn=" + ssn + "]";
	}

}
