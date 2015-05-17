package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;
import com.mauriciotogneri.jan.kernel.symbols.Operand.Type;

public class ProgramDefinition
{
	private Type returnType;
	private final List<String> imports = new ArrayList<>();
	private final Map<String, FunctionDefinition> functions = new HashMap<>();
	
	public void addImport(String path)
	{
		this.imports.add(path);
	}
	
	public Type getReturnType()
	{
		return this.returnType;
	}
	
	private void setTree()
	{
		Collection<FunctionDefinition> list = this.functions.values();
		
		for (FunctionDefinition function : list)
		{
			function.setTree(this);
		}
	}
	
	public void analyzeTree()
	{
		setTree();
		
		// TODO
		
		this.returnType = Type.UNDEFINED;
	}
	
	public void addFunction(FunctionDefinition function)
	{
		this.functions.put(function.getName().lexeme, function);
	}
	
	public boolean containsFunction(String name)
	{
		return this.functions.containsKey(name);
	}
	
	public FunctionDefinition getFunction(String name)
	{
		return this.functions.get(name);
	}
	
	public Value evaluate(FunctionDefinition function)
	{
		Context context = new Context();
		
		return function.evaluate(this, context);
	}
	
	public Value run()
	{
		return evaluate(this.functions.get("\\"));
	}
	
	public boolean hasEntryPoint()
	{
		return this.functions.containsKey("\\");
	}
}