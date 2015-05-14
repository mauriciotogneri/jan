package com.mauriciotogneri.prefix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Program
{
	private final Map<String, Function> functions = new HashMap<>();
	
	public void parse(String filePath)
	{
		// TODO
	}
	
	public Value evaluate(String line)
	{
		Expression expression = new Expression(line);
		
		return evaluate(expression);
	}
	
	private Value evaluate(Expression expression)
	{
		Stack<Value> stack = new Stack<>();
		
		List<ExpressionElement> elements = expression.getElements();
		
		for (ExpressionElement element : elements)
		{
			if (element instanceof Value)
			{
				stack.add((Value)element);
			}
			else if (element instanceof Symbol)
			{
				applySymbol((Symbol)element, stack);
			}
		}
		
		if (stack.size() != 1)
		{
			throw new RuntimeException("Stack should have only one element");
		}
		
		return stack.pop();
	}
	
	private void applySymbol(Symbol symbol, Stack<Value> stack)
	{
		if (symbol.isPrimitive())
		{
			symbol.apply(stack);
		}
		else
		{
			Function function = this.functions.get(symbol.name);
			
			if (function == null)
			{
				throw new RuntimeException("Function '" + symbol.name + "' not defined");
			}
			
			// TODO
		}
	}
	
	public boolean isValid()
	{
		return true;
	}
	
	public Value run()
	{
		return null;
	}
	
	public boolean hasEntryPoint()
	{
		return false;
	}
}