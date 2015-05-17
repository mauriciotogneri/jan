package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.SemanticException;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

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
	
	public void addParameter(Token name)
	{
		this.parameters.add(name);
	}
	
	public void addExpression(ExpressionDefinition expression)
	{
		this.expressions.add(expression);
	}
	
	public Value evaluate(ProgramDefinition program, Context context)
	{
		for (ExpressionDefinition expression : this.expressions)
		{
			Value result = expression.evaluate(program, context);
			
			if (result != null)
			{
				return result;
			}
		}
		
		throw new RuntimeException("Function '" + this.name.lexeme + "' didn't return any value");
	}
}