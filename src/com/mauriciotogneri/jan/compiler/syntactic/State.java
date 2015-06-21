package com.mauriciotogneri.jan.compiler.syntactic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

public abstract class State
{
	private final Program program;

	protected State(Program program)
	{
		this.program = program;
	}
	
	protected Program getProgram()
	{
		return program;
	}
	
	protected void addImport(String path)
	{
		program.addImport(path);
	}
	
	protected void addFunction(Function function)
	{
		if (function.isEmpty())
		{
			throw new SyntacticException("Function is empty", function.getName());
		}
		
		if (containsFunction(function))
		{
			throw new SyntacticException("Function '" + function.getName().lexeme + "' already defined", function.getName().line, function.getName().column);
		}
		
		program.addFunction(function);
	}

	private boolean containsFunction(Function function)
	{
		return program.containsFunction(function.getName().lexeme);
	}
	
	public abstract State process(Token token);
}