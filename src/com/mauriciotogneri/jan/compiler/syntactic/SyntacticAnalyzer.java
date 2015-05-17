package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Program;

public class SyntacticAnalyzer
{
	public Program analyze(List<Token> tokens)
	{
		StateMachine stateMachine = new StateMachine();
		
		return stateMachine.getProgram(tokens);
	}
}