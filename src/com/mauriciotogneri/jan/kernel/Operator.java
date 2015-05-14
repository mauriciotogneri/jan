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

public class Operator implements Symbol
{
	public final String name;
	public final PrimitiveFunction primitive;
	
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
	
	public Operator(String name)
	{
		this.name = name;
		this.primitive = getPrimitive(name);
	}
	
	public boolean isPrimitive()
	{
		return this.primitive != null;
	}
	
	public void apply(Stack<Operand> stack)
	{
		this.primitive.apply(stack);
	}
	
	private PrimitiveFunction getPrimitive(String symbol)
	{
		if (symbol.equals(PrimitiveAdd.SYMBOL))
		{
			return primitiveAdd;
		}
		else if (symbol.equals(PrimitiveSubtract.SYMBOL))
		{
			return primitiveSubstract;
		}
		else if (symbol.equals(PrimitiveMultiply.SYMBOL))
		{
			return primitiveMultiply;
		}
		else if (symbol.equals(PrimitiveDivide.SYMBOL))
		{
			return primitiveDivide;
		}
		else if (symbol.equals(PrimitivePower.SYMBOL))
		{
			return primitivePower;
		}
		else if (symbol.equals(PrimitiveModule.SYMBOL))
		{
			return primitiveModule;
		}
		else if (symbol.equals(PrimitiveIncrement.SYMBOL))
		{
			return primitiveIncrement;
		}
		else if (symbol.equals(PrimitiveDecrement.SYMBOL))
		{
			return primitiveDecrement;
		}
		else if (symbol.equals(PrimitiveEqual.SYMBOL))
		{
			return primitiveEqual;
		}
		else if (symbol.equals(PrimitiveNotEqual.SYMBOL))
		{
			return primitiveNotEqual;
		}
		else if (symbol.equals(PrimitiveLessThan.SYMBOL))
		{
			return primitiveLessThan;
		}
		else if (symbol.equals(PrimitiveLessThanOrEqual.SYMBOL))
		{
			return primitiveLessThanOrEqual;
		}
		else if (symbol.equals(PrimitiveGreaterThan.SYMBOL))
		{
			return primitiveGreaterThan;
		}
		else if (symbol.equals(PrimitiveGreaterThanOrEqual.SYMBOL))
		{
			return primitiveGreaterThanOrEqual;
		}
		else if (symbol.equals(PrimitiveAnd.SYMBOL))
		{
			return primitiveAnd;
		}
		else if (symbol.equals(PrimitiveOr.SYMBOL))
		{
			return primitiveOr;
		}
		else if (symbol.equals(PrimitiveNegation.SYMBOL))
		{
			return primitiveNegation;
		}
		else if (symbol.equals(PrimitiveIf.SYMBOL))
		{
			return primitiveIf;
		}
		else
		{
			return null;
		}
	}
}