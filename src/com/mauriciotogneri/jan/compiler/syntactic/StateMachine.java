package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.syntactic.states.InitialState;
import com.mauriciotogneri.jan.kernel.Program;

public class StateMachine
{
	public Program getProgram(List<Token> tokens)
	{
		Program program = new Program();
		
		State state = new InitialState(program);
		
		for (Token token : tokens)
		{
			state = state.process(token);
		}
		
		return program;
	}
}