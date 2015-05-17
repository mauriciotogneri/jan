package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

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
	
	public void setTree(ProgramDefinition program)
	{
		for (ExpressionDefinition expression : this.expressions)
		{
			expression.setTree(this.parameters, program);
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