package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;

public class FunctionParameterStartState extends State
{
	private final FunctionDefinition function;
	
	public FunctionParameterStartState(ProgramDefinition program, FunctionDefinition function)
	{
		super(program);
		
		this.function = function;
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type.isSeparator())
		{
			return this;
		}
		else if (token.type == Type.NEW_LINE)
		{
			return new FunctionDefinedState(getProgram(), this.function);
		}
		else if (token.type == Type.SYMBOL)
		{
			this.function.addParameter(token);
			
			return new FunctionParameterEndState(getProgram(), this.function);
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}