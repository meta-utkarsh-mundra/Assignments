package ds2Stack;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *This class will have test cases related to postfix evaluation
 */
public class TestPostfixEvaluation {

	PostfixEvaluation postfix;

	/**
	 * This method will have positive test cases
	 */
	@Test
	public void postFixExpression() {
		postfix = new PostfixEvaluation("2 3 1 * +");
		assertEquals(5, postfix.evaluatePostfix());

		postfix = new PostfixEvaluation("2 3 6 * + 22 -");
		assertEquals(-2, postfix.evaluatePostfix());

		postfix = new PostfixEvaluation("2 3 5 * + 2 -");
		assertEquals(15, postfix.evaluatePostfix());
	}

	/**
	 * This method will have negative test cases
	 */
	@Test(expected = AssertionError.class)
	public void postFixExpressionError() {
		// gives error for invalid operation
		postfix = new PostfixEvaluation("2 3 5 * 2 - \\");
		assertEquals(-11, postfix.evaluatePostfix());

		// gives error when expression is not found
		postfix = new PostfixEvaluation("");
		assertEquals(-11, postfix.evaluatePostfix());

		// gives error when no operator is found or expression length is 2
		postfix = new PostfixEvaluation("2 3");
		assertEquals(-11, postfix.evaluatePostfix());
	}
}