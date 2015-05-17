package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

public class ExpressionStartState extends State
{
	private final Function function;
	private final Expression expression;
	
	public ExpressionStartState(Program program, Function function, Expression expression)
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
			
			return new ExpressionEndState(getProgram(), this.function, this.expression);
		}
		else if (token.type == Type.NEW_LINE)
		{
			if (!this.expression.isEmpty())
			{
				this.function.addExpression(this.expression);
			}
			
			return new FunctionDefinedState(getProgram(), this.function);
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}