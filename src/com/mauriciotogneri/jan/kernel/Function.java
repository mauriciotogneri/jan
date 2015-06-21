package com.mauriciotogneri.jan.kernel;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.SemanticException;

import java.util.ArrayList;
import java.util.List;

public class Function
{
	private final Token name;
	private final Parameters parameters = new Parameters();
	private final List<Expression> expressions = new ArrayList<>();
	
	public Function(Token name)
	{
		this.name = name;
	}
	
	public Token getName()
	{
		return name;
	}
	
	public int getNumberOfParameters()
	{
		return parameters.getSize();
	}
	
	public void setTree(Program program)
	{
		for (int i = 0; i < expressions.size(); i++)
		{
			Expression expression = expressions.get(i);
			
			boolean isLastExpression = (i == (expressions.size() - 1));
			boolean conditional = expression.setTree(parameters, program);
			
			if (isLastExpression == conditional)
			{
				throw new SemanticException("Function '" + name.lexeme + "' must end with a non conditional expression");
			}
		}
	}
	
	public boolean isEmpty()
	{
		return expressions.isEmpty();
	}
	
	public void addParameter(String name)
	{
		parameters.add(name);
	}
	
	public void addExpression(Expression expression)
	{
		expressions.add(expression);
	}
	
	public Value evaluate(Context context)
	{
		for (Expression expression : expressions)
		{
			Value result = expression.evaluate(context);
			
			if (result != null)
			{
				return result;
			}
		}
		
		throw new RuntimeException("Function '" + name.lexeme + "' didn't return any value");
	}
}