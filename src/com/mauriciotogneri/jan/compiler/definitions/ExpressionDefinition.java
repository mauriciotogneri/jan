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
import com.mauriciotogneri.jan.compiler.semantic.nodes.list.ListCloseNode;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

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
					if (token.type == Type.LIST_CLOSE)
					{
						stack.push(node);
					}
					else if (token.type == Type.LIST_OPEN)
					{
						List<Node> list = new ArrayList<>();
						
						LiteralNode listNode = null;
						
						while (!stack.isEmpty())
						{
							Node operand = stack.pop();
							
							if (operand instanceof ListCloseNode)
							{
								listNode = new LiteralNode(token, list);
							}
							else
							{
								list.add(operand);
							}
						}
						
						if (listNode != null)
						{
							stack.push(listNode);
						}
						else
						{
							throw new SemanticException("List close not found", token);
						}
					}
					else
					{
						applyOperator(token, node, stack);
					}
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
			Node node = stack.pop();
			
			if (node instanceof ListCloseNode)
			{
				throw new SemanticException("Invalid list definition", this.elements.get(0));
			}
			else
			{
				this.root = node;
			}
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
	
	private boolean isConditional()
	{
		return (this.root instanceof IfNode);
	}
	
	public Value evaluate(ProgramDefinition program, Context context)
	{
		return this.root.evaluate(program, context);
	}
}