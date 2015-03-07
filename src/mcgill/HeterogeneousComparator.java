package mcgill;

import java.util.Comparator;

public class HeterogeneousComparator implements Comparator<Object> {


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o1.getClass().equals(o2.getClass())) {
			return ((Comparable) o1).compareTo((Comparable) o2);
		}
		else if (o1 instanceof Double) {
			return -1;
		}
		else if (o2 instanceof Double) {
			return 1;
		}
		else if (o1 instanceof String) {
			if (o2 instanceof Employee) {
				return ((String) o1).compareTo(((Employee) o2).getLastName());
			}
		}
		else if (o1 instanceof Employee) {
			if (o2 instanceof String) {
				return ((Employee) o1).getLastName().compareTo((String) o2);
			}
		}
		throw new RuntimeException("HeterogeneousComparator can only deal with Double, String and Employee, but you passed: " + o2.getClass());
	}

}
