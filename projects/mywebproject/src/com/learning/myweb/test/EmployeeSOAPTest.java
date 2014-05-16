package com.learning.myweb.test;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import service.EmployeeServiceSoap11BindingStub;

public class EmployeeSOAPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EmployeeServiceSoap11BindingStub stub = new EmployeeServiceSoap11BindingStub();
			System.out.println(stub.calculateTax(200));
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
