package ds.students;

import ds.students.Token.Type;

/**
 * @author simont
 *
 */
public class Calculator {
				
	public DSQueue infixToPostfix(DSQueue infix) {
		
		// create an empty queue to store the number
		DSQueue outputQueue = new DSQueue();
				
		// create an empty stack to store the operator
		DSStack operatorStack = new DSStack();
				
		// point the temp variable as the parameter infix head
		// through the getHead() method.--1
		Node temp = infix.list.head;
		
		// while there are token to read
		while(temp != null) {
				
			if(temp.getToken().type == Type.OPERAND) {
							
				outputQueue.offer(temp.getToken());				
			}
						
			// if the token is an operator type,
			// we need to work out the precedent rule.--3
			else if(temp.getToken().type == Type.OPERATOR) {
								
				// to ensure the operator stack is not empty, then we compare.
				// (If the stack is empty, it makes no scents to keep comparing the operators in the stack.
				// Because the conversion is complete.)
				// token -- O1      has equal or less than	token 02 at the top of stack 				
				if(!operatorStack.isEmpty() && 
					temp.getToken().getPrecedence() <= operatorStack.peek().getPrecedence()) {
					
					// pop O2 off from the stack
					Token appendToken = operatorStack.pop();				
					
					// add this token to the output queue.
					outputQueue.offer(appendToken);
									
				}
				
					// else push this operator to the stack.
					operatorStack.push(temp.getToken());					
				}
															
			// if the token is a left parenthesis "(",
			// push it to the stack.--4
			else if(temp.getToken().type == Type.PAREN && 
					temp.getToken().getOperator().equals("(")) {
								
				operatorStack.push(temp.getToken());
								
			}
						
			// if the token is a right parenthesis ")" --5
			else if(temp.getToken().type == Type.PAREN &&
					temp.getToken().getOperator().equals(")")) {
				
				// pop the top off the stack, add it to output queue 
				// until the token at the top is a left parenthesis "("
				while(!operatorStack.peek().getOperator().equals("(")) {
										
					Token insertToken = operatorStack.pop();
					
					outputQueue.offer(insertToken);
				}
								
				// at this point, there should be only one token left.
				// If this is not an left parenthesis "(". We have an error.
				 if (!operatorStack.isEmpty() && 
					 !operatorStack.peek().getOperator().equals("(")) {
	               
	                   System.out.println("Error: Invalid expression!");
	                   
	                   return null;
	               }
	               
				 else {
					 
					 // if the else code runs, it means we find a match (a pair parenthesis "( )") 
					 // at this point. It remove the the left parenthesis from the stack "(", and
					 // throw away the incoming right parenthesis ")".
					 operatorStack.pop();
	               }												
			}
					
			// update the temp variable,
			// point to the next Node.
			temp = temp.next;						
		}
				
		// while there is no more token to be read, 
		// if our stack still has a "(", then we have an input error.
		while (!operatorStack.isEmpty())
	       {
	           if (operatorStack.peek().getOperator().equals("("))
	           {
	               System.out.println("Error: Invalid expression!");
	               return null;
	           }
	          
	           // else we will pop everything off from the stack
	           // to the queue.
	           outputQueue.offer(operatorStack.pop());
	       }
		
		
				
		return outputQueue;
	}

	
	public double evaluatePostfix(DSQueue exp)
	{
		return 0;
	}
}
