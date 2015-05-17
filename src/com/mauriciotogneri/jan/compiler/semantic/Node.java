package com.mauriciotogneri.jan.compiler.semantic;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class Node
{
	// TODO: remove token?
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
}