package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;

public class ImportStartState extends State
{
	public ImportStartState(ProgramDefinition program)
	{
		super(program);
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type.isSeparator())
		{
			return this;
		}
		else if (token.type == Type.STRING)
		{
			return new ImportEndState(getProgram(), token.lexeme);
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}