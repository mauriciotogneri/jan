package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

public class InitialState extends State
{
	public InitialState(Program program)
	{
		super(program);
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type == Type.NEW_LINE)
		{
			return this;
		}
		else if (token.type == Type.IMPORT)
		{
			return new ImportState(getProgram());
		}
		else if (token.type == Type.SYMBOL)
		{
			return new FunctionDefinitionState(getProgram(), new Function(token));
		}
		else if (token.type == Type.ANONYMOUS_FUNCTION)
		{
			return new AnonymousFunctionState(getProgram(), new Function(token));
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}