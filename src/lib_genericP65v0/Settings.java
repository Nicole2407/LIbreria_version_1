package lib_genericP65v0;

import java.util.ArrayList;
import java.util.List;

public interface Settings<T> {
	
public final String developer = "Nicole Paredes 1751478676";

public final List<String> elements = new ArrayList<>();

public default void addElements(String element) {
	this.elements.add(element);
}

public default void listElements() {
	for(int i =0; i<elements.size(); i++) {
		System.out.printf("%d.- %s",(i+1),elements.get(i));
	}
}

public default T searchElement(T...elements) {
	T element = elements[0];
	for(int i = 1; i<elements.length; i++) {
		if(element.toString().equals(element.toString())) {
			return element;
		}
	}
	return null;
}


}
