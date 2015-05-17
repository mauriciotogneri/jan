package com.mauriciotogneri.jan.kernel.nodes.list;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

public class ListCloseNode extends PrimitiveNode
{
	public ListCloseNode(Token token)
	{
		super(token, 0);
	}
	
	@Override
	public Value evaluate(Context context)
	{
		return null;
	}
}