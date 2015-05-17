package com.mauriciotogneri.jan.kernel.nodes;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Node;
import com.mauriciotogneri.jan.kernel.Value;

public class ParameterNode extends Node
{
	public final int index;
	
	public ParameterNode(Token token, int index)
	{
		super(token);
		
		this.index = index;
	}
	
	@Override
	public Value evaluate(Context context)
	{
		return context.get(this.index);
	}
}