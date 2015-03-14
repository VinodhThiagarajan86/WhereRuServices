package com.hack.whereru;

import java.io.Serializable;

import org.springframework.data.annotation.Id;


public class Customer implements Serializable {
	 
	
	static final long serialVersionUID = 1L;	
    
	 @Id
    private String id;

    private String firstName;
    private String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 	
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}