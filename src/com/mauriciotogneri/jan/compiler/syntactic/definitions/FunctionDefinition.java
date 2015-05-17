package com.mauriciotogneri.jan.compiler.syntactic.definitions;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class FunctionDefinition
{
	private final Token name;
	private final List<Token> parameters = new ArrayList<>();
	private final List<ExpressionDefinition> expressions = new ArrayList<>();
	
	public FunctionDefinition(Token name)
	{
		this.name = name;
	}
	
	public Token getName()
	{
		return this.name;
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