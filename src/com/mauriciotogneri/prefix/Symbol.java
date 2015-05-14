package com.mauriciotogneri.prefix;

import java.util.Stack;
import com.mauriciotogneri.prefix.primitive.PrimitiveFunction;
import com.mauriciotogneri.prefix.primitive.PrimitivePlus;

public class Symbol implements ExpressionElement
{
	public final String name;
	public final PrimitiveFunction primitiveFunction;
	
	private static final PrimitiveFunction primitivePlus = new PrimitivePlus();
	
	public Symbol(String name)
	{
		this.name = name;
		this.primitiveFunction = getPrimitiveFunction(name);
	}
	
	public boolean isPrimitive()
	{
		return this.primitiveFunction != null;
	}
	
	public void apply(Stack<Value> stack)
	{
		this.primitiveFunction.apply(stack);
	}
	
	private PrimitiveFunction getPrimitiveFunction(String name)
	{
		if (name.equals("+"))
		{
			return primitivePlus;
		}
		else
		{
			return null;
		}
	}
}