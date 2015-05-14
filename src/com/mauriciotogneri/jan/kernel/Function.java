package com.mauriciotogneri.jan.kernel;

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
	
	public void apply(Stack<Operand> stack, Map<String, Function> functions)
	{
		Operand[] actualParameters = getOperands(stack, this.formalParameters.size());
		
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
	
	private Operand[] getOperands(Stack<Operand> stack, int size)
	{
		Operand[] result = new Operand[size];
		
		int index = 0;
		
		while (index < size)
		{
			result[index++] = stack.pop();
		}
		
		return result;
	}
	
	private void evaluate(Expression expression, Stack<Operand> stack, Operand[] actualParameters, Map<String, Function> functions)
	{
		List<Symbol> symbols = expression.getSymbol();
		
		for (Symbol symbol : symbols)
		{
			if (symbol instanceof Operand)
			{
				stack.add((Operand)symbol);
			}
			else if (symbol instanceof Operator)
			{
				applyOperator((Operator)symbol, stack, actualParameters, functions);
			}
		}
	}
	
	private void applyOperator(Operator operator, Stack<Operand> stack, Operand[] actualParameters, Map<String, Function> functions)
	{
		if (operator.isPrimitive())
		{
			operator.apply(stack);
		}
		else
		{
			Parameter formalParameter = this.formalParameters.get(operator.name);
			
			if (formalParameter != null)
			{
				stack.add(actualParameters[formalParameter.index]);
			}
			else
			{
				Function function = functions.get(operator.name);
				
				if (function == null)
				{
					throw new RuntimeException("Function '" + operator.name + "' not defined");
				}
				
				function.apply(stack, functions);
			}
		}
	}
}