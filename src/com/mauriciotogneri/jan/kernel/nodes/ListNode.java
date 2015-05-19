package com.mauriciotogneri.jan.kernel.nodes;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Node;
import com.mauriciotogneri.jan.kernel.Value;

public class ListNode extends Node
{
	private final List<Node> list;
	
	public ListNode(Token token, List<Node> list)
	{
		super(token);
		
		this.list = list;
	}
	
	@Override
	public Value evaluate(Context context)
	{
		List<Value> result = new ArrayList<>();
		
		for (Node node : this.list)
		{
			result.add(node.evaluate(context));
		}
		
		return Value.asList(result);
	}
}