package ds2InfixToPostfix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class will have the method for infix to postfix conversion
 */
public class TestInfixToPostfix {

	/**
	 * This method will validate positive test cases
	 */
	@Test
	public void infixToPostfixTest() {
		String postfix = InfixToPostfix.infixToPostfix("2 + 3");
		assertEquals("23+", postfix);

		String secondPostfix = InfixToPostfix.infixToPostfix("a * b");
		assertEquals("ab*", secondPostfix);

		String thirdPostfix = InfixToPostfix.infixToPostfix("a + ( b * c )");
		assertEquals("abc*+", thirdPostfix);

		String fourthPostfix = InfixToPostfix.infixToPostfix("a * ( b + c ) * d");
		assertEquals("abc+*d*", fourthPostfix);

		String fifthPostfix = InfixToPostfix.infixToPostfix("( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )");
		assertEquals("30023+4321-*847+/", fifthPostfix);
	}

	/**
	 * This method will validate negative test cases
	 */
	@Test(expected = AssertionError.class)
	public void infixToPostfixErrorTest() {
		String firstPostfix = InfixToPostfix.infixToPostfix("2 + 3");
		assertEquals("2+3", firstPostfix);

		// give error when expression is invalid
		String secondPostfix = InfixToPostfix.infixToPostfix("a * b []");
		assertEquals("ab*", secondPostfix);
	}
}