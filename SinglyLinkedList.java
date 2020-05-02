public class SinglyLinkedList {
	private Node head;
 
	public boolean isEmpty() {
		return (head == null);
	}
	// used to insert a node at the start of linked list
	// public void insertFirst(int data) {
	// 	Node newNode = new Node();
	// 	newNode.data = data;
	// 	newNode.next = head;
	// 	head = newNode;
	// }
 
	// used to delete node from start of linked list
	public Node deleteFirst() {
		Node temp = head;
		head = head.next;
		return temp;
	}
 
	// Use to delete node after particular node
	public void deleteAfter(Node after) {
		Node temp = head;
		while (temp.next != null && temp.data != after.data) {
			temp = temp.next;
		}
		if (temp.next != null)
			temp.next = temp.next.next;
	}
 
	// used to insert a node at the start of linked list
	public void insertLast(int data) {
    //    Node current = head;
        if(head == null){
            Node newNode = new Node();
            newNode.data = data;
            head = newNode;
			head.local_depth = 1;
        }
        else{
            Node current = head;
		while (current.next != null) {
			current = current.next; // we'll loop until current.next is null
		}
		Node newNode = new Node();
		newNode.data = data;
        current.next = newNode;
        }
	}
 
	// For printing Linked List
	public void printLinkedList() {
		System.out.println("Printing LinkedList (head --> last) ");
		Node current = head;
		while (current != null) {
			current.displayNodeData();
			current = current.next;
		}
		System.out.println();
    }
    // Size of Linked List
    public int size() {
		int c = 0;
		Node current = head;
		while (current != null) {
			c = c + 1;
			current = current.next;
		}
		return c;
    }
    public int getlocaldepth(){
        return head.local_depth;
	}
	public int getIndex(){
		if(head!=null)
			return head.index;
		else
			return -1;
	}
	public void setLocalDepth(int ld){
		if(head == null){
            Node newNode = new Node();
            newNode.local_depth = ld;
            head = newNode;
        }
	}
	public void setIndex(int i){
		if(head == null){
            Node newNode = new Node();
            newNode.index = i;
            head = newNode;
		}
		else{
			head.index = i;
		}
	}
	public void split(SinglyLinkedList sll1, SinglyLinkedList sll2, int first_index, int second_index, int global_depth){

		// sll1.setIndex(first_index);
		// sll2.setIndex(second_index);
		// sll1.head.index = first_index;
		// sll2.head.index = second_index;
		Node current = head;
		while(current!=null){
			if(getLastBits(current.data,global_depth)==first_index){
				sll1.insertLast(current.data);
				sll1.setIndex(first_index);
			}
			else{
				sll2.insertLast(current.data);
				sll2.setIndex(second_index);
			}
			current = current.next;
		}
		sll1.head.local_depth = this.head.local_depth+1;
		sll2.head.local_depth = this.head.local_depth+1;
	}
	static int getLastBits(int num,int d){        
        int number=(int)(Math.pow(2.00000,d)); 
        number--;
        return num&number;     // bitwise and 
    }
}
 