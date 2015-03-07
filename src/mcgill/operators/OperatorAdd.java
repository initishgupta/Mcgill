package mcgill.operators;

public class OperatorAdd implements Operator{

	private double totalSum = 0;
	
	@Override
	public void take(String operand) {
		try {
			double possibleOperand = Double.valueOf(operand);
			totalSum += possibleOperand;
		} catch (NumberFormatException ex) {
			// ignore, but is usually bad to ignore
			System.out.println("OperatorAdd: operand [" + operand + "] is not a number, so it is ignored");
		}
	}

	@Override
	public void apply() {
		System.out.println("Total sum of number is: " + totalSum);
	}
	
	
	

}
