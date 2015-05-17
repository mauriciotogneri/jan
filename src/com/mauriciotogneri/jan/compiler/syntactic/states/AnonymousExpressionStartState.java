package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ExpressionDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ProgramDefinition;

public class AnonymousExpressionStartState extends State
{
	private final FunctionDefinition function;
	private final ExpressionDefinition expression;
	
	public AnonymousExpressionStartState(ProgramDefinition program, FunctionDefinition function, ExpressionDefinition expression)
	{
		super(program);
		
		this.function = function;
		this.expression = expression;
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type.isSeparator())
		{
			return this;
		}
		else if (token.type.isExpressionToken())
		{
			this.expression.addElement(token);
			
			return new AnonymousExpressionEndState(getProgram(), this.function, this.expression);
		}
		else if (token.type == Type.NEW_LINE)
		{
			if (this.expression.isEmpty())
			{
				throw new SyntacticException("Anonymous function is empty", token);
			}
			
			this.function.addExpression(this.expression);
			addFunction(this.function);
			
			return new InitialState(getProgram());
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}