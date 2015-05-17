package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.nodes.Node;

public class ExpressionDefinition
{
	private final List<Token> elements = new ArrayList<>();
	private Node node;
	
	public void addElement(Token token)
	{
		this.elements.add(0, token);
	}
	
	public boolean isEmpty()
	{
		return this.elements.isEmpty();
	}
	
	public void setTree(ParametersDefinition parameters, ProgramDefinition program)
	{
		Stack<Node> stack = new Stack<>();
		
		for (Token token : this.elements)
		{
			System.out.print(token.lexeme + " ");
		}
		
		System.out.println("\n");
	}
	
	public Node getTree()
	{
		return this.node;
	}
}