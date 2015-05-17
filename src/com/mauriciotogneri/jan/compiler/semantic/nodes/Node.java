package com.mauriciotogneri.jan.compiler.semantic.nodes;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class Node
{
	public final Token value;
	private final List<Node> children = new ArrayList<>();
	
	public Node(Token value)
	{
		this.value = value;
	}
	
	public void addChild(Token token)
	{
		this.children.add(new Node(token));
	}
}