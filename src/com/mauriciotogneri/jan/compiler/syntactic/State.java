package com.mauriciotogneri.jan.compiler.syntactic;

import com.mauriciotogneri.jan.compiler.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;

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
	
	protected void addImport(String path)
	{
		this.program.addImport(path);
	}
	
	protected void addFunction(FunctionDefinition function)
	{
		this.program.addFunction(function);
	}
	
	protected boolean containsFunction(FunctionDefinition function)
	{
		return this.program.containsFunction(function);
	}
	
	public abstract State process(Token token);
}