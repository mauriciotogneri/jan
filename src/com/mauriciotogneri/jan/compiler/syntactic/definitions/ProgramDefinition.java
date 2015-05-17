package com.mauriciotogneri.jan.compiler.syntactic.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramDefinition
{
	private final List<String> imports = new ArrayList<>();
	private final Map<String, FunctionDefinition> functions = new HashMap<>();
	
	public void addImport(String path)
	{
		this.imports.add(path);
	}
	
	public void addFunction(FunctionDefinition function)
	{
		this.functions.put(function.getName().lexeme, function);
	}
}