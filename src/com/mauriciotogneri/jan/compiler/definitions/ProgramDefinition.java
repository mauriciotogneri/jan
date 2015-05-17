package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.Collection;
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
	
	public void setTree()
	{
		Collection<FunctionDefinition> list = this.functions.values();
		
		for (FunctionDefinition function : list)
		{
			function.setTree(this);
		}
	}
	
	public void addFunction(FunctionDefinition function)
	{
		this.functions.put(function.getName().lexeme, function);
	}
	
	public boolean containsFunction(FunctionDefinition function)
	{
		return this.functions.containsKey(function.getName().lexeme);
	}
}