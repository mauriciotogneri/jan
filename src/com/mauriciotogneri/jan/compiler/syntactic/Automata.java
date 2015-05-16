package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.states.InitialState;

public class Automata
{
	public ProgramDefinition getProgram(List<Token> tokens)
	{
		ProgramDefinition program = new ProgramDefinition();
		
		State state = new InitialState(program);
		
		for (Token token : tokens)
		{
			state = state.process(token);
		}
		
		return program;
	}
}