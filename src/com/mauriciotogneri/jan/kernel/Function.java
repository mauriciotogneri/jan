package com.mauriciotogneri.jan.kernel;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.SemanticException;

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
		return this.name;
	}
	
	public int getNumberOfParameters()
	{
		return this.parameters.getSize();
	}
	
	public void setTree(Program program)
	{
		for (int i = 0; i < this.expressions.size(); i++)
		{
			Expression expression = this.expressions.get(i);
			
			boolean isLastExpression = (i == (this.expressions.size() - 1));
			boolean conditional = expression.setTree(this.parameters, program);
			
			if (isLastExpression == conditional)
			{
				throw new SemanticException("Function '" + this.name.lexeme + "' must end with a non conditional expression");
			}
		}
	}
	
	public boolean isEmpty()
	{
		return this.expressions.isEmpty();
	}
	
	public void addParameter(String name)
	{
		this.parameters.add(name);
	}
	
	public void addExpression(Expression expression)
	{
		this.expressions.add(expression);
	}
	
	public Value evaluate(Context context)
	{
		for (Expression expression : this.expressions)
		{
			Value result = expression.evaluate(context);
			
			if (result != null)
			{
				return result;
			}
		}
		
		throw new RuntimeException("Function '" + this.name.lexeme + "' didn't return any value");
	}
}