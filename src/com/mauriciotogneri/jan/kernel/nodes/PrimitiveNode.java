package com.mauriciotogneri.jan.kernel.nodes;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.AddNode;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.DecrementNode;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.DivisionNode;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.IncrementNode;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.ModuleNode;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.MultiplicationNode;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.PowerNode;
import com.mauriciotogneri.jan.kernel.nodes.arithmetic.SubstractNode;
import com.mauriciotogneri.jan.kernel.nodes.conditional.IfElseNode;
import com.mauriciotogneri.jan.kernel.nodes.conditional.IfNode;
import com.mauriciotogneri.jan.kernel.nodes.list.IndexNode;
import com.mauriciotogneri.jan.kernel.nodes.list.LengthNode;
import com.mauriciotogneri.jan.kernel.nodes.list.ListCloseNode;
import com.mauriciotogneri.jan.kernel.nodes.list.ListOpenNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.AndNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.EqualNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.GreaterEqualNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.GreaterNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.LessEqualNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.LessNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.NegationNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.NotEqualNode;
import com.mauriciotogneri.jan.kernel.nodes.logic.OrNode;

public abstract class PrimitiveNode extends OperatorNode
{
	public PrimitiveNode(Token token, int numberOfOperands)
	{
		super(token, numberOfOperands);
	}
	
	public static PrimitiveNode get(Token token)
	{
		if (token.type == Type.ARITHMETIC_ADD)
		{
			return new AddNode(token);
		}
		else if (token.type == Type.ARITHMETIC_SUBSTRACT)
		{
			return new SubstractNode(token);
		}
		else if (token.type == Type.ARITHMETIC_MULTIPLICATION)
		{
			return new MultiplicationNode(token);
		}
		else if (token.type == Type.ARITHMETIC_DIVISION)
		{
			return new DivisionNode(token);
		}
		else if (token.type == Type.ARITHMETIC_POWER)
		{
			return new PowerNode(token);
		}
		else if (token.type == Type.ARITHMETIC_MODULE)
		{
			return new ModuleNode(token);
		}
		else if (token.type == Type.ARITHMETIC_INCREMENT)
		{
			return new IncrementNode(token);
		}
		else if (token.type == Type.ARITHMETIC_DECREMENT)
		{
			return new DecrementNode(token);
		}
		else if (token.type == Type.LOGIC_EQUAL)
		{
			return new EqualNode(token);
		}
		else if (token.type == Type.LOGIC_NOT_EQUAL)
		{
			return new NotEqualNode(token);
		}
		else if (token.type == Type.LOGIC_GREATER)
		{
			return new GreaterNode(token);
		}
		else if (token.type == Type.LOGIC_GREATER_EQUAL)
		{
			return new GreaterEqualNode(token);
		}
		else if (token.type == Type.LOGIC_LESS)
		{
			return new LessNode(token);
		}
		else if (token.type == Type.LOGIC_LESS_EQUAL)
		{
			return new LessEqualNode(token);
		}
		else if (token.type == Type.LOGIC_AND)
		{
			return new AndNode(token);
		}
		else if (token.type == Type.LOGIC_OR)
		{
			return new OrNode(token);
		}
		else if (token.type == Type.LOGIC_NEGATION)
		{
			return new NegationNode(token);
		}
		else if (token.type == Type.CONDITIONAL_IF)
		{
			return new IfNode(token);
		}
		else if (token.type == Type.CONDITIONAL_IF_ELSE)
		{
			return new IfElseNode(token);
		}
		else if (token.type == Type.LIST_INDEX)
		{
			return new IndexNode(token);
		}
		else if (token.type == Type.LIST_LENGTH)
		{
			return new LengthNode(token);
		}
		else if (token.type == Type.LIST_OPEN)
		{
			return new ListOpenNode(token);
		}
		else if (token.type == Type.LIST_CLOSE)
		{
			return new ListCloseNode(token);
		}
		
		return null;
	}
}