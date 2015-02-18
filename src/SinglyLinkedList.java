public class SinglyLinkedList {

	Node head, tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	int totalSum() {
		int sum = 0;
		Node current = head, previous = null;
		while (current != null) {
			sum += current.data;
			previous = current;
			current = current.next;
		}
		return sum;
	}

	void addNode(Node n) {
		if (head == null) {
			head = n;
			head.next = null;
			return;
		}
		Node current = head;

		while (current != null) {
			Node temp = current;
			if (n.data < current.data) {
				current.data = n.data;
				n.next = current.next;
				current.next = n;
				return;
			}
			temp = current.next;

		}

	}

	void addLast(Node n) {

		if (n == null) {
			return;
		}
		if (head == null) {
			head = n;
			tail = n;
			return;
		}
		n.next = null;
		Node current = head;
		tail.next = n;
		tail = n;

	}

	void removeNode(Node n) {
		if (n != null)
			return;
		Node current = head;
		while (current != null) {
			if (n.data == current.data) {
				current.data = current.next.data;
				current.next = current.next.next;
				return;
			}
		}
	}

	void removeLast(Node n) {

		if (n == null || head == null)
			return;
		Node secondLast = head;
		while (secondLast.next != tail) {
			secondLast = secondLast.next;
		}
		tail = secondLast;
		tail.next = null;
	}

	class Node {
		int data;
		Node next;

		Node() {
			data = 0;
			next = null;
		}

		void setdata(int data) {
			this.data = data;
		}

		void setnext(Node next) {
			this.next = next;
		}

	}

	public static void main(String args[]) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head.setdata(10);
	}

}
