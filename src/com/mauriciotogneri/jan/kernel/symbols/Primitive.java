package com.mauriciotogneri.jan.kernel.symbols;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.symbols.primitives.PrimitiveFunction;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitiveAdd;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitiveDecrement;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitiveDivide;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitiveIncrement;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitiveModule;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitiveMultiply;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitivePower;
import com.mauriciotogneri.jan.kernel.symbols.primitives.arithmetic.operations.PrimitiveSubtract;
import com.mauriciotogneri.jan.kernel.symbols.primitives.conditional.PrimitiveIf;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveAnd;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveEqual;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveGreaterThan;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveGreaterThanOrEqual;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveLessThan;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveLessThanOrEqual;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveNegation;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveNotEqual;
import com.mauriciotogneri.jan.kernel.symbols.primitives.logic.operations.PrimitiveOr;

public class Primitive extends Operator
{
	private final PrimitiveFunction primitive;
	
	// arithmetic
	private static final Primitive primitiveAdd = new Primitive(PrimitiveAdd.SYMBOL, new PrimitiveAdd());
	private static final Primitive primitiveSubstract = new Primitive(PrimitiveSubtract.SYMBOL, new PrimitiveSubtract());
	private static final Primitive primitiveMultiply = new Primitive(PrimitiveMultiply.SYMBOL, new PrimitiveMultiply());
	private static final Primitive primitiveDivide = new Primitive(PrimitiveDivide.SYMBOL, new PrimitiveDivide());
	private static final Primitive primitivePower = new Primitive(PrimitivePower.SYMBOL, new PrimitivePower());
	private static final Primitive primitiveModule = new Primitive(PrimitiveModule.SYMBOL, new PrimitiveModule());
	private static final Primitive primitiveIncrement = new Primitive(PrimitiveIncrement.SYMBOL, new PrimitiveIncrement());
	private static final Primitive primitiveDecrement = new Primitive(PrimitiveDecrement.SYMBOL, new PrimitiveDecrement());
	
	// logic
	private static final Primitive primitiveEqual = new Primitive(PrimitiveEqual.SYMBOL, new PrimitiveEqual());
	private static final Primitive primitiveNotEqual = new Primitive(PrimitiveNotEqual.SYMBOL, new PrimitiveNotEqual());
	private static final Primitive primitiveLessThan = new Primitive(PrimitiveLessThan.SYMBOL, new PrimitiveLessThan());
	private static final Primitive primitiveLessThanOrEqual = new Primitive(PrimitiveLessThanOrEqual.SYMBOL, new PrimitiveLessThanOrEqual());
	private static final Primitive primitiveGreaterThan = new Primitive(PrimitiveGreaterThan.SYMBOL, new PrimitiveGreaterThan());
	private static final Primitive primitiveGreaterThanOrEqual = new Primitive(PrimitiveGreaterThanOrEqual.SYMBOL, new PrimitiveGreaterThanOrEqual());
	private static final Primitive primitiveAnd = new Primitive(PrimitiveAnd.SYMBOL, new PrimitiveAnd());
	private static final Primitive primitiveOr = new Primitive(PrimitiveOr.SYMBOL, new PrimitiveOr());
	private static final Primitive primitiveNegation = new Primitive(PrimitiveNegation.SYMBOL, new PrimitiveNegation());
	
	// conditional
	private static final Primitive primitiveIf = new Primitive(PrimitiveIf.SYMBOL, new PrimitiveIf());
	
	private Primitive(String symbol, PrimitiveFunction primitive)
	{
		super(symbol);
		
		this.primitive = primitive;
	}
	
	public void apply(Stack<Operand> stack)
	{
		this.primitive.apply(stack);
	}
	
	public static Primitive getPrimitive(String symbol)
	{
		if (symbol.equals(primitiveAdd.name))
		{
			return primitiveAdd;
		}
		else if (symbol.equals(primitiveSubstract.name))
		{
			return primitiveSubstract;
		}
		else if (symbol.equals(primitiveMultiply.name))
		{
			return primitiveMultiply;
		}
		else if (symbol.equals(primitiveDivide.name))
		{
			return primitiveDivide;
		}
		else if (symbol.equals(primitivePower.name))
		{
			return primitivePower;
		}
		else if (symbol.equals(primitiveModule.name))
		{
			return primitiveModule;
		}
		else if (symbol.equals(primitiveIncrement.name))
		{
			return primitiveIncrement;
		}
		else if (symbol.equals(primitiveDecrement.name))
		{
			return primitiveDecrement;
		}
		else if (symbol.equals(primitiveEqual.name))
		{
			return primitiveEqual;
		}
		else if (symbol.equals(primitiveNotEqual.name))
		{
			return primitiveNotEqual;
		}
		else if (symbol.equals(primitiveLessThan.name))
		{
			return primitiveLessThan;
		}
		else if (symbol.equals(primitiveLessThanOrEqual.name))
		{
			return primitiveLessThanOrEqual;
		}
		else if (symbol.equals(primitiveGreaterThan.name))
		{
			return primitiveGreaterThan;
		}
		else if (symbol.equals(primitiveGreaterThanOrEqual.name))
		{
			return primitiveGreaterThanOrEqual;
		}
		else if (symbol.equals(primitiveAnd.name))
		{
			return primitiveAnd;
		}
		else if (symbol.equals(primitiveOr.name))
		{
			return primitiveOr;
		}
		else if (symbol.equals(primitiveNegation.name))
		{
			return primitiveNegation;
		}
		else if (symbol.equals(primitiveIf.name))
		{
			return primitiveIf;
		}
		else
		{
			return null;
		}
	}
}