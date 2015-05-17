package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.SemanticException;

public class FunctionDefinition
{
	private final Token name;
	private final ParametersDefinition parameters = new ParametersDefinition();
	private final List<ExpressionDefinition> expressions = new ArrayList<>();
	
	public FunctionDefinition(Token name)
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
	
	public void setTree(ProgramDefinition program)
	{
		for (int i = 0; i < this.expressions.size(); i++)
		{
			ExpressionDefinition expression = this.expressions.get(i);
			
			boolean conditional = expression.setTree(this.parameters, program);
			
			if (((i < (this.expressions.size() - 1)) && !conditional) || ((i == (this.expressions.size() - 1)) && conditional))
			{
				throw new SemanticException("Function '" + this.name.lexeme + "' must end with a non conditional expression");
			}
		}
	}
	
	public boolean isEmpty()
	{
		return this.expressions.isEmpty();
	}
	
	public void addParameter(Token name)
	{
		this.parameters.add(name);
	}
	
	public void addExpression(ExpressionDefinition expression)
	{
		this.expressions.add(expression);
	}
}