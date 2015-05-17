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
		if (function.isEmpty())
		{
			throw new SyntacticException("Function is empty", function.getName());
		}
		
		if (containsFunction(function))
		{
			throw new SyntacticException("Function '" + function.getName().lexeme + "' already defined", function.getName().line, function.getName().column);
		}
		
		this.program.addFunction(function);
	}
	
	protected boolean containsFunction(FunctionDefinition function)
	{
		return this.program.containsFunction(function.getName().lexeme);
	}
	
	public abstract State process(Token token);
}