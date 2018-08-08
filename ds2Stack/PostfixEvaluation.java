package ds2Stack;

/**
 * This class consists methods for evaluation of postfix expression
 *
 */
public class PostfixEvaluation {
	private String[] postfixExpression;
	StackLinkedList<Integer> intValues = new StackLinkedList<Integer>();

	//Constructor to initialise the values
	public PostfixEvaluation(String postfixExpression) {
		this.postfixExpression = postfixExpression.split(" ");
	}

	/**
	 * This method evaluate for postfix expression using Stack
	 * @return the evaluated answer
	 */
	public int evaluatePostfix() {
		if (postfixExpression.length == 0) {
			throw new AssertionError("The expression is not found");
		} else if (postfixExpression.length == 2) {
			throw new AssertionError("The expression can not be evaluated");
		}
		String expression;

		for (int i = 0; i < postfixExpression.length; i++) {
			expression = postfixExpression[i];
			try {
				if (Integer.parseInt(expression) >= 0) {
					intValues.push(Integer.parseInt(expression));
				}
			} catch (Exception e) {
				int secondValue = intValues.pop();
				int firstValue = intValues.pop();
				int intermediateExpression;
				switch (expression) {
				case "+":
					intermediateExpression = firstValue + secondValue;
					break;
				case "-":
					intermediateExpression = firstValue - secondValue;
					break;
				case "*":
					intermediateExpression = firstValue * secondValue;
					break;
				case "/":
					if(secondValue == 0) {
						throw new ArithmeticException("Divide by zero exception");
					}
					intermediateExpression = firstValue / secondValue;
					break;
				default:
					throw new AssertionError("The given expression is not valid!!");
				}
				intValues.push(intermediateExpression);
			}
		}
		int resultExpression = intValues.pop();
		
		// throw error if stack is not empty at last
		if (intValues.isEmpty()) {
			return resultExpression;
		}
		else {
			throw new AssertionError("The given expression is not complete!! Missing Operator!");
		}
	}

	/**
	 * Main class to check for the values for postfix expression
	 * @param args
	 */
	public static void main(String[] args) {
		PostfixEvaluation obj = new PostfixEvaluation("2 3 1 * +");
		int resultExpression = obj.evaluatePostfix();
		System.out.println(resultExpression);
	}
}