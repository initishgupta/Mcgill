package mcgill.operators;

public class OperatorFactory {
	public Operator newInstance(String type) throws IllegalArgumentException {
		
		if ("opAdd".equals(type)) {
			return new OperatorAdd();
		}
		else if ("opConcatenate".equals(type)) {
			return new OperatorConcate();
		}
		else if ("opSortAsc".equals(type)) {
			return new OperatorSortAscending();
		}
		throw new IllegalArgumentException(type + " was given as an Operator Type, but it doesn't exist in the system");

	}
}
