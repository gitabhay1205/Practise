
public class ExceptionExample {

	public static void main(String args[]) {

		try {
			subClass();

		} catch (MyException e) {

		   
		}
	}

	private static void subClass() throws MyException {

		int result = 0;
		if (result > 0) {

		} else {
			throw new MyException("RESULT IS EMPTY");
		}

	}

}
