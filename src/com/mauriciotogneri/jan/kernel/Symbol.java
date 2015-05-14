package com.mauriciotogneri.jan.kernel;

import java.util.Stack;
import com.mauriciotogneri.jan.primitives.PrimitiveFunction;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitiveAdd;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitiveDecrement;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitiveDivide;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitiveIncrement;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitiveModule;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitiveMultiply;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitivePower;
import com.mauriciotogneri.jan.primitives.arithmetic.operations.PrimitiveSubtract;
import com.mauriciotogneri.jan.primitives.conditional.PrimitiveIf;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveAnd;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveEqual;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveGreaterThan;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveGreaterThanOrEqual;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveLessThan;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveLessThanOrEqual;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveNegation;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveNotEqual;
import com.mauriciotogneri.jan.primitives.logic.operations.PrimitiveOr;

public class Symbol implements ExpressionElement
{
	public final String name;
	public final PrimitiveFunction primitiveFunction;
	
	// arithmetic
	private static final PrimitiveFunction primitiveAdd = new PrimitiveAdd();
	private static final PrimitiveFunction primitiveSubstract = new PrimitiveSubtract();
	private static final PrimitiveFunction primitiveMultiply = new PrimitiveMultiply();
	private static final PrimitiveFunction primitiveDivide = new PrimitiveDivide();
	private static final PrimitiveFunction primitivePower = new PrimitivePower();
	private static final PrimitiveFunction primitiveModule = new PrimitiveModule();
	private static final PrimitiveFunction primitiveIncrement = new PrimitiveIncrement();
	private static final PrimitiveFunction primitiveDecrement = new PrimitiveDecrement();
	
	// logic
	private static final PrimitiveFunction primitiveEqual = new PrimitiveEqual();
	private static final PrimitiveFunction primitiveNotEqual = new PrimitiveNotEqual();
	private static final PrimitiveFunction primitiveLessThan = new PrimitiveLessThan();
	private static final PrimitiveFunction primitiveLessThanOrEqual = new PrimitiveLessThanOrEqual();
	private static final PrimitiveFunction primitiveGreaterThan = new PrimitiveGreaterThan();
	private static final PrimitiveFunction primitiveGreaterThanOrEqual = new PrimitiveGreaterThanOrEqual();
	private static final PrimitiveFunction primitiveAnd = new PrimitiveAnd();
	private static final PrimitiveFunction primitiveOr = new PrimitiveOr();
	private static final PrimitiveFunction primitiveNegation = new PrimitiveNegation();
	
	// conditional
	private static final PrimitiveFunction primitiveIf = new PrimitiveIf();
	
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
		if (name.equals(PrimitiveAdd.SYMBOL))
		{
			return primitiveAdd;
		}
		else if (name.equals(PrimitiveSubtract.SYMBOL))
		{
			return primitiveSubstract;
		}
		else if (name.equals(PrimitiveMultiply.SYMBOL))
		{
			return primitiveMultiply;
		}
		else if (name.equals(PrimitiveDivide.SYMBOL))
		{
			return primitiveDivide;
		}
		else if (name.equals(PrimitivePower.SYMBOL))
		{
			return primitivePower;
		}
		else if (name.equals(PrimitiveModule.SYMBOL))
		{
			return primitiveModule;
		}
		else if (name.equals(PrimitiveIncrement.SYMBOL))
		{
			return primitiveIncrement;
		}
		else if (name.equals(PrimitiveDecrement.SYMBOL))
		{
			return primitiveDecrement;
		}
		else if (name.equals(PrimitiveEqual.SYMBOL))
		{
			return primitiveEqual;
		}
		else if (name.equals(PrimitiveNotEqual.SYMBOL))
		{
			return primitiveNotEqual;
		}
		else if (name.equals(PrimitiveLessThan.SYMBOL))
		{
			return primitiveLessThan;
		}
		else if (name.equals(PrimitiveLessThanOrEqual.SYMBOL))
		{
			return primitiveLessThanOrEqual;
		}
		else if (name.equals(PrimitiveGreaterThan.SYMBOL))
		{
			return primitiveGreaterThan;
		}
		else if (name.equals(PrimitiveGreaterThanOrEqual.SYMBOL))
		{
			return primitiveGreaterThanOrEqual;
		}
		else if (name.equals(PrimitiveAnd.SYMBOL))
		{
			return primitiveAnd;
		}
		else if (name.equals(PrimitiveOr.SYMBOL))
		{
			return primitiveOr;
		}
		else if (name.equals(PrimitiveNegation.SYMBOL))
		{
			return primitiveNegation;
		}
		else if (name.equals(PrimitiveIf.SYMBOL))
		{
			return primitiveIf;
		}
		else
		{
			return null;
		}
	}
}