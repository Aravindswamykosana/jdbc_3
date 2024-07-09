package jdbc_3.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdbc_3.dao.StudentCrud;
import jdbc_3.dto.Student;

public class User {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentCrud sc1=new StudentCrud();
		Scanner sc=new Scanner(System.in);
		boolean b=false;
		do {
			System.out.println("1:insert\n2:update\n3:delete\n4:fetch");
			System.out.println("enter the option:");
			int option=sc.nextInt();
			switch(option){
			case 1:
				System.out.println("enter the size:");
				int size=sc.nextInt();
				List<Student> li=new ArrayList<Student>();
				for(int i=0;i<size;i++) {
					System.out.println("enter the id:");
					int id=sc.nextInt();
					System.out.println("enter the name:");
					String name=sc.next();
					System.out.println("enter the email:");
					String email=sc.next();
					System.out.println("enter the phone:");
					long phone=sc.nextLong();
					System.out.println("enter the password:");
					String pwd=sc.next();
					System.out.println("enter the marks:");
					double marks=sc.nextDouble();
					Student sc11=new Student(id,name, email, phone, pwd, marks);
					li.add(sc11);
					sc1.batchSave(li);
				}
				System.out.println("inserted");
				break;
			case 2:
				System.out.println("updated");
				break;
			case 3:
				System.out.println("deleted");
				break;
			case 4:
				System.out.println("fetch");
				break;
				default:
					System.out.println("enter the correct option..");
					break;
			}
		}while(b);	
	}
}
