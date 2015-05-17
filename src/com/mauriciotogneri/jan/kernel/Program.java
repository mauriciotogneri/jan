package com.mauriciotogneri.jan.kernel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mauriciotogneri.jan.kernel.Value.Type;

public class Program
{
	private Type returnType;
	private final List<String> imports = new ArrayList<>();
	private final Map<String, Function> functions = new HashMap<>();
	
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
		Collection<Function> list = this.functions.values();
		
		for (Function function : list)
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
	
	public void addFunction(Function function)
	{
		this.functions.put(function.getName().lexeme, function);
	}
	
	public boolean containsFunction(String name)
	{
		return this.functions.containsKey(name);
	}
	
	public Function getFunction(String name)
	{
		return this.functions.get(name);
	}
	
	public Value evaluate(Function function)
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