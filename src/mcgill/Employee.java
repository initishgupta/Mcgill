package mcgill;


public class Employee implements Comparable<Employee> {
	
	
	public static Employee valueOf(String possibleEmployeeString) throws ParseException {
		if (possibleEmployeeString.indexOf("employee") == 0 &&
				possibleEmployeeString.lastIndexOf(")") == possibleEmployeeString.length() - 1) {
			String [] parenthesisSpli = possibleEmployeeString.split("\\(");
			if (parenthesisSpli.length != 2) {
				throwExceptionParseError(possibleEmployeeString);
			}
			String[] arguments = parenthesisSpli[1].split(",");
			if (arguments.length != 3) {
				throwExceptionParseError(possibleEmployeeString);
			}
			String salaryStr = arguments[2].substring(0, arguments[2].length() - 1);
			try {
				Double.valueOf(arguments[0]);
				throwExceptionParseError(possibleEmployeeString);
			} catch (NumberFormatException ex) {
				// here is safe to ignore!
			}
			
			try {
				Double.valueOf(arguments[1]);
				throwExceptionParseError(possibleEmployeeString);
			} catch (NumberFormatException ex) {
				// here is safe to ignore!
			}
		
			try {
				double salary = Double.valueOf(salaryStr); 
				return new Employee(arguments[0], arguments[1], salary);
			} catch (NumberFormatException ex) {
				throwExceptionParseError(possibleEmployeeString);
			}
		} 
		throwExceptionParseError(possibleEmployeeString);
		return null;
	}

	private String firstName;
	private String lastName;
	private double salary;
	
	public Employee(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		return lastName.compareTo(o.lastName);
	}

	
	
	private static void throwExceptionParseError(String possibleEmployeeString) throws ParseException {
		throw new ParseException("String " + possibleEmployeeString + " is not an employee");
		
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getSalary() {
		return salary;
	}
	
	

}
