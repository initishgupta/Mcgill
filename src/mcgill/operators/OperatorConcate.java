package mcgill.operators;



import mcgill.Employee;
import mcgill.ParseException;

public class OperatorConcate implements Operator{

	private StringBuilder stringBuilder = new StringBuilder();
	
	@Override
	public void take(String operand) {
		try {
			Employee.valueOf(operand);
			System.out.println("OperatorConcate: operand [" + operand + "] is an employee, so it is ignored");
			return;
		} catch (ParseException ex) {
			// safe to ignore, it is expected
		}
		
		stringBuilder.append(operand);
	}

	@Override
	public void apply() {
		System.out.println("Concatenated string: " + stringBuilder.toString());
	}
	
	
	

}
