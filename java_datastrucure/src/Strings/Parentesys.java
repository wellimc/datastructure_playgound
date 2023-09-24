package Strings;

import java.util.*;

public class Parentesys {
	
	public static List<String> openOperators = Arrays.asList("(","[","{") ;
	public static List<String> closeOperators = Arrays.asList(")","]","}") ;
	public static Map<String,String> operators = new HashMap<String,String>();
	

	public static void main(String args[]) {
		
		operators.put("(",")");
		operators.put("{","}");
		operators.put("[","]");

		String str = "(])";
		boolean result = validaText(str);
		System.out.print(result);

	}
	
	public static boolean validaText(String s) {
		
		operators.put("(",")");
		operators.put("{","}");
		operators.put("[","]");
        
        Stack<String> openedSatck = new Stack<String>();
		
		char[] textChar = s.toCharArray();
		
		for(int i=0;i<textChar.length;i++) {
			 String operator = String.valueOf(textChar[i]);

			 if(openOperators.contains(operator)) {
				
				 openedSatck.push(operator);
			 }
			 
			 if(closeOperators.contains(operator)) {
				 String operToClose = null;
				 if (!openedSatck.isEmpty()) {
					 operToClose  = openedSatck.peek();
				 }else {
					 return false;
				 }
				 String operToMatch = operators.get(operToClose);
				
						 
				 if(operator.equals(operToMatch)){
					 openedSatck.pop();	
				 }else {
					 return false;
				 }
			 }
			 
		}
		
		if(openedSatck.isEmpty()) {
			return true;
		}else {
			return false;
		}
			
		
	}

}
