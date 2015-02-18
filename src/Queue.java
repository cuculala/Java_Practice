import java.util.ArrayList;

public class Queue {

	ArrayList<Object> bag;

	Queue() {
		bag = new ArrayList<Object>();
	}

	Object get() {
		return bag.get(0);
	}

	void insert(Object obj) {
		bag.add(obj);
	}

	int getSize() {
		return bag.size();
	}

}
