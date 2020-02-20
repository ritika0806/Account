package com.capgemini.ui;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Scanner;
import com.capgemini.bean.BankBean;
import com.capgemini.exceptions.AccountNotFoundException;
import com.capgemini.service.BankService;

public class BankUI {
	public static void main(String[] args) throws AccountNotFoundException {
		BankService bsi = new BankService();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("\n\t\t\t\tWelcome to My Bank Services");
			System.out.println(
					"1.Account Creation\n2.Update Customer Name\n3.Update Customer Contact\n4.Update Customer Address\n5.Delete Account\n6.Exit");
			System.out.print("Enter Your Choice: ");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
			
				System.out.println("Your Account Id : ");
				int account_id = sc.nextInt();
				System.out.print("Enter Name:");
				String name=sc.next();
				for (int i = 0; i < name.length(); i++) {
					char c = name.charAt(i);
					if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
						System.out.println("Name must contain only alphabets");
						name=sc.next();
					}
				}
				
				System.out.print("Enter contact Number: ");
				String contactno = sc.next();
				while((contactno.length())!=10){
					System.out.println("Contact number must contain 10 digits");
					contactno = sc.next();
				}
				
				System.out.print("Enter Aadhar Number: ");
			    String aadharno = sc.next();
			    while(!(aadharno.length()== 12)){
			    System.out.println("Aadhar no must contain 12 digits");
			    aadharno=sc.next();
			    }
			    
				System.out.print("Enter PAN: ");
				String pan = sc.next();
			
				System.out.print("Enter DOB: ");
				String dob = sc.next();
			
				
				System.out.print("Enter Gender: (F or M)");
				String gender = sc.next();
				
				System.out.print("Enter Address: ");
				String address = sc.next();
				
				
				BankBean bean=new BankBean(account_id,name,contactno,aadharno,pan,dob,gender,address);
				@SuppressWarnings("unused")
				BankBean b=bsi.CreateAccount(bean);
				System.out.println("------------------------------------------------------------");
				System.out.println("Thank you " + name + " Your Account is created Successully");
				System.out.println("Your account details are:");
				@SuppressWarnings("rawtypes")
				ArrayList a=bsi.printDetails(account_id);
				for(Object i:a)
					System.out.println(i+"\n");
					System.out.println("__________________________________________________________");
				break;
				
			case 2:
				System.out.print("Enter Account Id: ");
				account_id = sc.nextInt();
				
				boolean flag=false;
				try {
					flag = bsi.checkAccountId(account_id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (flag==true)
					System.out.println("Account found");
					else
					throw new AccountNotFoundException("Account ID does not exists");
					

				System.out.println("Enter name to be updated");
				name=sc.next();
				b=bsi.UpdateCustomerName(account_id,name);
				System.out.println("Your account has been updated, your updated account details are:");
				a=bsi.printDetails(account_id);
				
				for(Object i:a)
					System.out.println(i+"\n");
					System.out.println("__________________________________________________________");
				break;
				
			case 3:
				System.out.print("Enter Account Id: ");
				account_id = sc.nextInt();
				
				flag=false;
				try {
					flag = bsi.checkAccountId(account_id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (flag==true)
					System.out.println("Account found");
					else
					throw new AccountNotFoundException("Account ID does not exists");
					
				System.out.print("Enter Customer Contact to be updated: ");
			    contactno = sc.next();
				 b=bsi.UpdateContactNo(account_id, contactno);
				 
				System.out.println("Your account has been updated, your updated account details are:");
				a=bsi.printDetails(account_id);
				for(Object i:a)
					System.out.println(i+"\n");
					System.out.println("__________________________________________________________");
				break;
				
			case 4:
				System.out.print("Enter Account Id: ");
				account_id = sc.nextInt();
				
				flag=false;
				try {
					flag = bsi.checkAccountId(account_id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (flag==true)
					System.out.println("Account found");
					else
					throw new AccountNotFoundException("Account ID does not exists");
					
				System.out.print("Enter Customer Address to be updated: ");
				address = sc.next();
				b= bsi.UpdateAddress(account_id, address);
				
				System.out.println("Your account has been updated, your updated account details are:");
				a=bsi.printDetails(account_id);
				for(Object i:a)
					System.out.println(i+"\n");
					System.out.println("__________________________________________________________");
				break;
				
			case 5:
				System.out.print("Enter Your Account Id: ");
			    account_id = sc.nextInt();
			    
			    flag=false;
				try {
					flag = bsi.checkAccountId(account_id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (flag==true)
					System.out.println("Account found");
					else
					throw new AccountNotFoundException("Account ID does not exists");
					
			    b=bsi.DeleteAccount(account_id);
			    System.out.println("-----------------------------------------------------------------------------");
			    System.out.println(" Your Acccount is deleted Succesfully\n");
				break;
			
			case 6:
				System.out.println("Thanks for Using our Bank Services....!!!");
				break;

			}

		} while (ch != 6);
	}

}


