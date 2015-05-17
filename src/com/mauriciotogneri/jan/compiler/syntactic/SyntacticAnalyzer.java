package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.List;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class SyntacticAnalyzer
{
	public ProgramDefinition analyze(List<Token> tokens)
	{
		StateMachine stateMachine = new StateMachine();
		
		return stateMachine.getProgram(tokens);
	}
}