package com.sunbeam;

public class Marks {

	private String subject;
	private double marks;
	
	public Marks() {
		
	}

	public Marks(String subject, int marks) {
		super();
		this.subject = subject;
		this.marks = marks;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Marks [subject=" + subject + ", marks=" + marks + "]";
	}
	
	
}
