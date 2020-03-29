package ExamenParical2;

import java.util.*;

public class Postfijo {
	public static void evaluaExpresionPostfijo(Queue<String> queue) {
		Stack<String> stack=new Stack<>();
		
		while (!queue.isEmpty()) {
			if (!queue.peek().equals("+") && !queue.peek().equals("-") && !queue.peek().equals("*") && !queue.peek().equals("/")) {
				stack.push(queue.remove());
			}
			else if (queue.peek().equals("+")) {
				queue.remove();
				double elemento1=Double.parseDouble(stack.pop());
				double elemento2=Double.parseDouble(stack.pop());
				double res=elemento1+elemento2;
				String str=res+"";
				stack.push(str);
			}
			else if (queue.peek().equals("-")) {
				queue.remove();
				double elemento1=Double.parseDouble(stack.pop());
				double elemento2=Double.parseDouble(stack.pop());
				double res=elemento2-elemento1;
				String str=res+"";
				stack.push(str);
			}
			else if (queue.peek().equals("*")) {
				queue.remove();
				double elemento1=Double.parseDouble(stack.pop());
				double elemento2=Double.parseDouble(stack.pop());
				double res=elemento1*elemento2;
				String str=res+"";
				stack.push(str);
			}
			else if (queue.peek().equals("/")) {
				queue.remove();
				double elemento1=Double.parseDouble(stack.pop());
				double elemento2=Double.parseDouble(stack.pop());
				double res=elemento1/elemento2;
				String str=res+"";
				stack.push(str);
			}
		}
		System.out.println(Double.parseDouble(stack.pop()));
	}
	
	
	public static void main(String[] args) {
		Queue<String> queue=new LinkedList<>();
		queue.add("1");
		queue.add("2");
		queue.add("+");
		queue.add("3");
		queue.add("4");
		queue.add("-");
		queue.add("*");
		
		evaluaExpresionPostfijo(queue);
	}
}
