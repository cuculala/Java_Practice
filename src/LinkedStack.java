
public class LinkedStack {

	static interface Linkable {
		public Linkable getNext();

		public void setNext(Linkable node);
	}

	Linkable head;

	public void push(Linkable node) {

	}

	public Object pop() {
		return (Object) head;
	}

	public class LinkableInteger implements LinkedStack.Linkable {

		int i;
		Linkable next;

		public LinkableInteger(int i) {
			this.i = i;
		}

		public LinkedStack.Linkable getNext() {
			return next;
		}

		public void setNext(LinkedStack.Linkable node) {
			next = node;
		}

	}

}
