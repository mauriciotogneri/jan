package com.mauriciotogneri.jan.kernel;

import java.util.Map;
import java.util.Stack;
import com.mauriciotogneri.jan.kernel.symbols.Operand;

public class Program
{
	private final Map<String, Function> functions;
	private final Expression entryPoint;
	
	public Program(Map<String, Function> functions, Expression entryPoint)
	{
		this.functions = functions;
		this.entryPoint = entryPoint;
	}
	
	public Operand evaluate(Expression expression)
	{
		Stack<Operand> stack = new Stack<>();
		
		Function function = new Function("");
		function.addExpression(expression);
		function.apply(stack, this.functions);
		
		if (stack.size() != 1)
		{
			throw new RuntimeException("Stack should have only one symbol at the end of a program");
		}
		
		return stack.pop();
	}
	
	public Operand run()
	{
		return evaluate(this.entryPoint);
	}
	
	public boolean hasEntryPoint()
	{
		return this.entryPoint != null;
	}
}