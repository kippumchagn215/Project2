//kjc190001 kippumchang
package project2;

public class Node<T> implements Comparable<Node<T>>  {
	Node next;
	T data;
	String name;
	
	Node(){
		}
	
	Node(Player p1){ // overloading the constructor so it can take player as parameter
		name = 	p1.name; // assign player name to node name
		data = (T) p1.toString(); // assign tostring that contains all the data of the player to nodes data
		}
 
	@Override
	public int compareTo(Node <T> n) { // overriding compareto function
		
		if((this.name.toUpperCase()).compareTo(n.name.toUpperCase())<0) { // comparing names of the node to sort in alphabetical order, also touppercase is used sort alphabetically regardless capitalletters 
			return 1; // return1
		}
		else { // if not in alphabetical order 
			return -1; // return -1
		}
	}
	
}

