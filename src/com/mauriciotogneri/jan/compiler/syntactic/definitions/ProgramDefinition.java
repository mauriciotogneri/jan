package com.mauriciotogneri.jan.compiler.syntactic.definitions;

import java.util.HashMap;
import java.util.Map;

public class ProgramDefinition
{
	private final Map<String, FunctionDefinition> functions = new HashMap<>();
	
	public void addFunction(FunctionDefinition function)
	{
		this.functions.put(function.name, function);
	}
}