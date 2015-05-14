package com.mauriciotogneri.prefix;

import java.util.ArrayList;
import java.util.List;

public class Function
{
	public final String name;
	public final List<Parameter> parameters = new ArrayList<>();
	public final List<Expression> expressions = new ArrayList<>();
	
	public Function(String name)
	{
		this.name = name;
	}
	
	public void addParameter(Parameter parameter)
	{
		this.parameters.add(parameter);
	}
	
	public void addExpression(Expression expression)
	{
		this.expressions.add(expression);
	}
}