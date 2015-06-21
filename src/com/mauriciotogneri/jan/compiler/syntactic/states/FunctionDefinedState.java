package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

public class FunctionDefinedState extends State
{
	private final Function function;
	
	public FunctionDefinedState(Program program, Function function)
	{
		super(program);
		
		this.function = function;
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type == Type.TAB)
		{
			return new ExpressionStartState(getProgram(), function, new Expression());
		}
		else if (token.type == Type.SYMBOL)
		{
			addFunction(function);
			
			return new FunctionDefinitionState(getProgram(), new Function(token));
		}
		else if (token.type == Type.NEW_LINE)
		{
			addFunction(function);
			
			return new InitialState(getProgram());
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}