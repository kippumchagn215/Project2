//kjc190001 kippumchang
package project2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LinkList<T>{
	Node head; // creating the head attribute, and initialize to null at first
	Node tail; // tail attribute with null value
	public void insert(Node node) { // takes node as a parameter
		if (head==null) { // if the head is null, the first node that was taken as parameter becomes the head
		head=node;
	}
		else { // if the head is already assigned 
		
		Node n = head; // temp head
		while(n.next!=null) { // loop through to find the node that is empty
			n=n.next; // n.next should be assigned to n everytime it loops, so it can move to next node
		}
		n.next=node;	// when the empty node is found, assign node value to it.
	}

		
	}
	public void sort() {
		
	
		try {
		Node n = head; // head pointer
		Node ptr = n.next; // pointer that points the next node of n
		while(n.compareTo(ptr)!=1||ptr!=null) { // while next is not null and and n.next is not equal to 1 
		if(n.compareTo(n.next)==1) {  // if n comparing to n.next equals 1, do nothing because it means its already in alphabetical order
		}
		else if(n.compareTo(n.next)==-1) { // if not in alphabetical order
			String temp =(String) n.data; // make temp string to hold data
			String tempname = (String) n.name; // make temp string to names
			n.data = ptr.data; // n.data is now n.next.data
			ptr.data = temp; // n.next.data is now n.data
			n.name = ptr.name; // n.name is now n.next.name
			ptr.name = tempname; // n.next.name is now n.name
		}
			n = n.next; // assign next value to n so it can move to next node
			ptr = n.next; // same as above
		}
		
	
		}catch(NullPointerException e){
			
		}
		
		
	
	}

	public void print(PrintWriter p3,Node n) { // taking printwriter to write on outputfile , and the temp node pointing head
		if(n.next!=null) { // if head.next is not null
			p3.println(n.data); // print out the data
			n = n.next; // move to next node
			print(p3,n); // recursive , so this function can loop till the end of the linklist
		}
		else{// if its at the end of the data
		p3.println(n.data); // print out the data of the last node
		p3.println(); // adding line at the end
		}
	}
	
	public void show (Node n) {
		if(n.next!=null) { // if head.next is not null
			System.out.println(n.data); // print out the data
			n = n.next; // move to next node
			show(n); // recursive , so this function can loop till the end of the linklist
		}
		else{// if its at the end of the data
		System.out.println(n.data); // print out the data of the last node
		System.out.println(); // adding line at the end
		}
	}
	
	public void delete(String name)   { // deleting the name and data of the player by taking name of the player user want to delete
		try {
		if(head!=null) { // if head is not null , to check if any values are in linklist
		if((head.name.toUpperCase()).equals(name.toUpperCase())==true){// regardless of the case, find the name entered in the Linklist
			head.name=null; // if the name matches delete the name
			head.data=null; // if the name matches delete data
			head = head.next; // now the head is head.next
			}
		else {
			Node node = head; 
			while(node.next!=null&&(node.next.name.toUpperCase()).equals(name.toUpperCase())==false) { // loop through linklist till it finds the node that matches the name entered
				node = node.next; // to iterate though linklist
			}
			if((node.next.name.toUpperCase()).equals(name.toUpperCase())==true) { // if it equals the name entered
				node.next.name = null; // name becomes null
				node.next.data = null; // data becomes null
				node.next = node.next.next; // when reading it skips the empty node
			}
		}
		}
		}catch(NullPointerException e) {
			System.out.println("The name you like to delete does not exist in the list");
		}
	}
	public void search(String name) {
		try {
			if(head!=null) { // if head is not null , to check if any values are in linklist
			if((head.name.toUpperCase()).equals(name.toUpperCase())==true){// regardless of the case, find the name entered in the Linklist
				System.out.println("head of the linklist is the name you entered");
				}
			else {
				Node node = head; 
				while(node.next!=null&&(node.next.name.toUpperCase()).equals(name.toUpperCase())==false) { // loop through linklist till it finds the node that matches the name entered
					node = node.next; // to iterate though linklist
				}
				if((node.next.name.toUpperCase()).equals(name.toUpperCase())==true) { // if it equals the name entered
					System.out.println("The name that you entered already exist in the list");
				}
			}
			}
			}catch(NullPointerException e) {
				System.out.println("The name you entered does not exist in the list");
			}
	}
		
	}
	


