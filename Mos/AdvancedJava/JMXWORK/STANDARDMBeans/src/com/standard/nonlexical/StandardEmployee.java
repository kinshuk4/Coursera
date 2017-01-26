package com.standard.nonlexical;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

import com.util.ObjectAnalyzer;

public class StandardEmployee implements EmpInterface{
	private String lastName;
	private String firstName;
	private long salary;
	private float tax;
	private boolean manager;
	private StandardAddress address;
	
	private long sequenceNumber=0;
	
	public StandardAddress getAddress() {
		return address;
	}
	public void setAddress(StandardAddress address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public StandardEmployee(String lastName, String firstName, long salary, float tax, boolean manager, StandardAddress address) {
		super();
		// TODO Auto-generated constructor stub
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.tax = tax;
		this.manager = manager;
		this.address = address;
	}
	public void reset() {
		lastName=null;
		firstName=null;
		salary=0;
		tax=0.0f;
		address.reset();
		
	}
	public String toString() {
		// TODO Auto-generated method stub
		return ObjectAnalyzer.genericToString(this);
	}
}