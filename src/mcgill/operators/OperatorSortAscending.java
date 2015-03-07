package mcgill.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mcgill.Employee;
import mcgill.HeterogeneousComparator;
import mcgill.ParseException;

public class OperatorSortAscending implements Operator{

	private HeterogeneousComparator comparator = new HeterogeneousComparator();
	private List<Object> listOfObjects = new ArrayList<>();
	
	@Override
	public void take(String operand) {
		if (wasDouble(operand)) {
			return;
		} 
		else if (wasEmployee(operand)) {
			return;
		}
		else {
			listOfObjects.add(operand);
		}
		
	}

	private boolean wasEmployee(String operand) {
		try {
			Employee employee = Employee.valueOf(operand);
			listOfObjects.add(employee);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	private boolean wasDouble(String operand) {
		try {
			Double possibleDouble = Double.valueOf(operand);
			listOfObjects.add(possibleDouble);
			return true;
		}	catch (NumberFormatException ex) {
			return false;
		}
	}

	@Override
	public void apply() {
		Collections.sort(listOfObjects, comparator);
		System.out.println("Sorted arguments:");
		for (Object o : listOfObjects) {
			System.out.println(o.toString());
		}
	}
	
	
	

}
