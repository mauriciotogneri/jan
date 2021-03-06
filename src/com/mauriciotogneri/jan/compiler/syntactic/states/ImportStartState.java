package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.kernel.Program;

public class ImportStartState extends State
{
	public ImportStartState(Program program)
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