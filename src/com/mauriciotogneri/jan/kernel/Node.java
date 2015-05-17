package com.mauriciotogneri.jan.kernel;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public abstract class Node
{
	public final Token token;
	
	private final List<Node> children = new ArrayList<>();
	
	public Node(Token token)
	{
		this.token = token;
	}
	
	public void addChild(Node node)
	{
		this.children.add(node);
	}
	
	protected Value get(int index, Program program, Context context)
	{
		Node node = this.children.get(index);
		
		return node.evaluate(program, context);
	}
	
	protected Context getContext(Program program, Context context)
	{
		Value[] values = new Value[this.children.size()];
		
		for (int i = 0; i < this.children.size(); i++)
		{
			Node node = this.children.get(i);
			
			values[i] = node.evaluate(program, context);
		}
		
		return new Context(values);
	}
	
	public abstract Value evaluate(Program program, Context context);
}