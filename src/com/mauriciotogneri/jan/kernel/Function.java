package com.mauriciotogneri.jan.kernel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import com.mauriciotogneri.jan.kernel.symbols.Operand;
import com.mauriciotogneri.jan.kernel.symbols.Operator;
import com.mauriciotogneri.jan.kernel.symbols.Parameter;
import com.mauriciotogneri.jan.kernel.symbols.Primitive;
import com.mauriciotogneri.jan.kernel.symbols.Symbol;

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
		int conditionalExpressions = this.expressions.size() - 1;
		
		for (int i = 0; i < this.expressions.size(); i++)
		{
			Expression expression = this.expressions.get(i);
			evaluate(expression, stack, actualParameters, functions);
			
			if (i < conditionalExpressions)
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
			throw new RuntimeException("Function '" + this.name + "' must return a value");
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
		List<Symbol> symbols = expression.getSymbols();
		
		for (Symbol symbol : symbols)
		{
			if (symbol instanceof Operand)
			{
				stack.add((Operand)symbol);
			}
			else if (symbol instanceof Parameter)
			{
				Parameter parameter = (Parameter)symbol;
				
				stack.add(actualParameters[parameter.index]);
			}
			else if (symbol instanceof Primitive)
			{
				Primitive primitive = (Primitive)symbol;
				
				primitive.apply(stack);
			}
			else
			{
				applyOperator((Operator)symbol, stack, functions);
			}
		}
	}
	
	private void applyOperator(Operator operator, Stack<Operand> stack, Map<String, Function> functions)
	{
		Function function = functions.get(operator.name);
		
		if (function == null)
		{
			// TODO: check at compiling time
			throw new RuntimeException("Function '" + operator.name + "' not defined");
		}
		
		function.apply(stack, functions);
	}
}