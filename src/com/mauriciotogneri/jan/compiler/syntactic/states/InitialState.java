package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ProgramDefinition;

public class InitialState extends State
{
	public InitialState(ProgramDefinition program)
	{
		super(program);
	}
	
	@Override
	public State process(Token token)
	{
		// if (token.type == Type.NEW_LINE)
		// {
		// return this;
		// }
		// if (token.type == Type.IMPORT)
		// {
		// return new InitialState(getProgram());
		// }
		// else
		// {
		// throw new SyntacticException(token);
		// }
		
		return this;
	}
}