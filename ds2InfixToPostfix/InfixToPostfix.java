package ds2InfixToPostfix;

import ds2Stack.Stack;
import ds2Stack.StackLinkedList;

/**
 * this class is used to convert an infix expression to postfix expression
 *
 */
public class InfixToPostfix {

    /**
     * this method is used to convert an infix expression to postfix expression
     * @param infixExpression
     * @return postfixExpression
     * @throws AssertionError if input is null
     */
    public static String infixToPostfix(String infixExpression) throws AssertionError{
        Stack<String> stack = new StackLinkedList<String>();
        
        if(infixExpression == null)
            throw new AssertionError("Invalid Input!");
        
        String[] expressionTokens = infixExpression.split(" ");
        String postfixExpression = "";
        
        for(String token: expressionTokens) {
            if("(".equals(token))
                stack.push(token);
            else if(")".equals(token)) {
                while(!("(".equals(stack.top())))
                    postfixExpression += stack.pop();
                
                stack.pop();
            }
            else if(isOperator(token)) {
                if(stack.isEmpty() || "(".equals(stack.top()) || getPrecedence(token) > getPrecedence(stack.top()))
                    stack.push(token);
                else {
                    while(!stack.isEmpty() && !("(".equals(stack.top())) && getPrecedence(token) <= getPrecedence(stack.top()))
                        postfixExpression += stack.pop();
                    
                    stack.push(token);
                }
            }
            else {
                postfixExpression += token;
            }
        }
        while(!stack.isEmpty())
            postfixExpression += stack.pop();
       
        return postfixExpression;
    }
    
    /**
     * helper method to check if the given token is an operator or not
     * @param token
     * @return boolean value
     */
    private static boolean isOperator(String token)
    {
        boolean isOperator = false;
        
        switch(token)
        {
            case "+":
            case "-":
            case "*":
            case "/":
            case "==":
            case "!=":
            case "<":
            case ">":
            case "<=":
            case ">=":
            case "&&":
            case "||":
            case "!":   isOperator = true;
                        break;
            default : isOperator = false; 
        }
        return isOperator;
    }
    
    /**
     * helper method used to get the precedence of the given operator
     * @param operator
     * @return precedence of the operator
     */
    private static int getPrecedence(String operator) {
        int precedence = 0; 
        switch(operator) {
            case "+": precedence = 5;
                      break;
                      
            case "-": precedence = 5;
                      break;
                      
            case "*": precedence = 6;
                      break;
                      
            case "/": precedence = 6;
                      break;
                      
            case "==":precedence = 3;
                      break;
                      
            case "!=":precedence = 3;
                      break;
                      
            case "<": precedence = 4;
                      break;
                      
            case ">": precedence = 4;
                      break;
                      
            case "<=":precedence = 4;
                      break;
                      
            case ">=":precedence = 4;
                      break;
                      
            case "&&":precedence = 2;
                      break;
                      
            case "||":precedence = 1;
                      break;
                      
            case "!": precedence = 7;
                      break;            
        }
        return precedence;
    }
 
    /**
     * main class to test for values for infix to postfix conversion
     * @param args
     */
	public static void main(String args[]) {
		String result=InfixToPostfix.infixToPostfix("a * ( b + c ) * d");
		System.out.println(result);
	}
}