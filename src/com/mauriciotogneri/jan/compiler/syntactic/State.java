package com.mauriciotogneri.jan.compiler.syntactic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.states.InitialState;

public abstract class State
{
	private final ProgramDefinition program;
	
	public State(ProgramDefinition program)
	{
		this.program = program;
	}
	
	protected ProgramDefinition getProgram()
	{
		return this.program;
	}
	
	protected void addFunction(FunctionDefinition function)
	{
		this.program.addFunction(function);
	}
	
	protected State createFunction(FunctionDefinition function)
	{
		addFunction(function);
		
		return new InitialState(this.program);
	}
	
	public abstract State process(Token token);
}