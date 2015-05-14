package com.mauriciotogneri.jan.kernel.symbols.primitives;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.symbols.Operand;

public interface PrimitiveFunction
{
	void apply(Stack<Operand> stack);
}