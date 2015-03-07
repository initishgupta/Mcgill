import mcgill.operators.Operator;
import mcgill.operators.OperatorFactory;

public class RunMe {
	public static void main(String[] args) {
		
		if(args.length <= 1) {
			System.err.print("Please write valid operator or arguments");
			return;
		}
		
		String operatorArgument = args[0];
		OperatorFactory operatorFactory = new OperatorFactory();
		Operator operator = operatorFactory.newInstance(operatorArgument);
		
		for (int i = 1; i < args.length; ++i) {
			operator.take(args[i]);
		}
		operator.apply();
		
	}
}
