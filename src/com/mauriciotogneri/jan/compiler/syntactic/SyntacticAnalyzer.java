package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

public class SyntacticAnalyzer
{
	public Program getProgram(List<Token> tokens)
	{
		StateMachine stateMachine = new StateMachine();
		
		return stateMachine.getProgram(tokens);
	}
	
	public Function getFunction(List<Token> tokens)
	{
		StateMachine stateMachine = new StateMachine();
		
		return stateMachine.getAnonymousFunction(tokens);
	}
}