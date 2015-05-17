package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.semantic.Node;
import com.mauriciotogneri.jan.compiler.semantic.SemanticException;
import com.mauriciotogneri.jan.compiler.semantic.nodes.FunctionNode;
import com.mauriciotogneri.jan.compiler.semantic.nodes.LiteralNode;
import com.mauriciotogneri.jan.compiler.semantic.nodes.OperatorNode;
import com.mauriciotogneri.jan.compiler.semantic.nodes.ParameterNode;
import com.mauriciotogneri.jan.compiler.semantic.nodes.PrimitiveNode;
import com.mauriciotogneri.jan.compiler.semantic.nodes.conditional.IfNode;

public class ExpressionDefinition
{
	private final List<Token> elements = new ArrayList<>();
	private Node root;
	
	public void addElement(Token token)
	{
		this.elements.add(0, token);
	}
	
	public boolean isEmpty()
	{
		return this.elements.isEmpty();
	}
	
	public boolean setTree(ParametersDefinition parameters, ProgramDefinition program)
	{
		Stack<Node> stack = new Stack<>();
		
		for (Token token : this.elements)
		{
			if (token.type.isLiteral())
			{
				LiteralNode node = new LiteralNode(token);
				stack.push(node);
			}
			else if (token.type == Type.SYMBOL)
			{
				if (parameters.containsParameter(token.lexeme))
				{
					ParameterNode node = new ParameterNode(token, parameters.getIndex(token.lexeme));
					stack.push(node);
				}
				else if (program.containsFunction(token.lexeme))
				{
					FunctionDefinition function = program.getFunction(token.lexeme);
					
					if (function != null)
					{
						FunctionNode node = new FunctionNode(token, function);
						
						applyOperator(token, node, stack);
					}
					else
					{
						throw new SemanticException("Function not defined", token);
					}
				}
				else
				{
					throw new SemanticException("Symbol not defined", token);
				}
			}
			else if (token.type.isPrimitive())
			{
				PrimitiveNode node = PrimitiveNode.get(token);
				
				if (node != null)
				{
					applyOperator(token, node, stack);
				}
				else
				{
					throw new SemanticException("Token not valid", token);
				}
			}
			else
			{
				throw new SemanticException("Token not valid", token);
			}
		}
		
		if (stack.size() == 1)
		{
			this.root = stack.pop();
		}
		else
		{
			throw new SemanticException("Invalid expression. It should return only one value", this.elements.get(0));
		}
		
		return isConditional();
	}
	
	private void applyOperator(Token token, OperatorNode node, Stack<Node> stack)
	{
		for (int i = 0; i < node.numberOfOperands; i++)
		{
			if (!stack.isEmpty())
			{
				Node operand = stack.pop();
				node.addChild(operand);
			}
			else
			{
				throw new SemanticException("Insufficient operands to apply primitive", token);
			}
		}
		
		stack.push(node);
	}
	
	public boolean isConditional()
	{
		return (this.root instanceof IfNode);
	}
	
	// TODO
	public Object evaluate()
	{
		return this.root;
	}
}