package com.mauriciotogneri.prefix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import com.mauriciotogneri.prefix.Value.Type;

public class Program
{
	private final Map<String, Function> functions = new HashMap<>();
	private Expression entryPoint;
	
	public void parse(String filePath)
	{
		// TODO
		
		Function function = new Function("double");
		function.addParameter(new Parameter("a", 0, Type.INT));
		
		Expression e = new Expression();
		e.add(new Symbol("*"));
		e.add(new Symbol("a"));
		e.add(new Symbol("a"));
		e.closeExpression();
		
		function.addExpression(e);
		
		this.functions.put(function.name, function);
		
		this.entryPoint = new Expression();
		
		this.entryPoint.add(new Symbol("double"));
		this.entryPoint.add(new Symbol("+"));
		this.entryPoint.add(new IntValue(3));
		this.entryPoint.add(new IntValue(2));
		
		this.entryPoint.closeExpression();
	}
	
	public Value evaluate(String line)
	{
		// TODO: parse line and get constructed expression
		
		Expression expression = new Expression();
		
		return evaluate(expression);
	}
	
	private Value evaluate(Expression expression)
	{
		Stack<Value> stack = new Stack<>();
		
		Function function = new Function("");
		function.addExpression(expression);
		function.apply(stack, this.functions);
		
		if (stack.size() != 1)
		{
			throw new RuntimeException("Stack should have only one element");
		}
		
		return stack.pop();
	}
	
	public Value run()
	{
		return evaluate(this.entryPoint);
	}
	
	public boolean hasEntryPoint()
	{
		return this.entryPoint != null;
	}
}