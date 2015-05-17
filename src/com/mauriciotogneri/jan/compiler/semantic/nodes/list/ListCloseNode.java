package com.mauriciotogneri.jan.compiler.semantic.nodes.list;

import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

public class ListCloseNode extends PrimitiveNode
{
	public ListCloseNode(Token token)
	{
		super(token, 0);
	}
	
	@Override
	public Value evaluate(ProgramDefinition program, Context context)
	{
		return null;
	}
}