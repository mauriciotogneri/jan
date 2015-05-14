package com.mauriciotogneri.prefix.kernel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Function
{
	public final String name;
	public final Map<String, Parameter> formalParameters = new HashMap<>();
	public final List<Expression> expressions = new ArrayList<>();
	
	public Function(String name)
	{
		this.name = name;
	}
	
	public void addParameter(Parameter parameter)
	{
		this.formalParameters.put(parameter.name, parameter);
	}
	
	public void addExpression(Expression expression)
	{
		this.expressions.add(expression);
	}
	
	public void apply(Stack<Value> stack, Map<String, Function> functions)
	{
		Value[] actualParameters = getValues(stack, this.formalParameters.size());
		
		int initialStackSize = stack.size();
		
		for (int i = 0; i < this.expressions.size(); i++)
		{
			Expression expression = this.expressions.get(i);
			evaluate(expression, stack, actualParameters, functions);
			
			if (i < (this.expressions.size() - 1))
			{
				// if expression
				
				if (stack.size() > initialStackSize)
				{
					break;
				}
			}
		}
		
		int finalStackSize = stack.size();
		
		if (finalStackSize <= initialStackSize)
		{
			throw new RuntimeException("Function '" + this.name + "' must return a single value");
		}
	}
	
	private Value[] getValues(Stack<Value> stack, int size)
	{
		Value[] result = new Value[size];
		
		int index = 0;
		
		while (index < size)
		{
			result[index++] = stack.pop();
		}
		
		return result;
	}
	
	private void evaluate(Expression expression, Stack<Value> stack, Value[] actualParameters, Map<String, Function> functions)
	{
		List<ExpressionElement> elements = expression.getElements();
		
		for (ExpressionElement element : elements)
		{
			if (element instanceof Value)
			{
				stack.add((Value)element);
			}
			else if (element instanceof Symbol)
			{
				applySymbol((Symbol)element, stack, actualParameters, functions);
			}
		}
	}
	
	private void applySymbol(Symbol symbol, Stack<Value> stack, Value[] actualParameters, Map<String, Function> functions)
	{
		if (symbol.isPrimitive())
		{
			symbol.apply(stack);
		}
		else
		{
			Parameter formalParameter = this.formalParameters.get(symbol.name);
			
			if (formalParameter != null)
			{
				stack.add(actualParameters[formalParameter.index]);
			}
			else
			{
				Function function = functions.get(symbol.name);
				
				if (function == null)
				{
					throw new RuntimeException("Function '" + symbol.name + "' not defined");
				}
				
				function.apply(stack, functions);
			}
		}
	}
}