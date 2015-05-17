package com.mauriciotogneri.jan.compiler.semantic.nodes;

import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.Node;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

public class ParameterNode extends Node
{
	public final int index;
	
	public ParameterNode(Token token, int index)
	{
		super(token);
		
		this.index = index;
	}
	
	@Override
	public Value evaluate(ProgramDefinition program, Context context)
	{
		return context.get(this.index);
	}
}