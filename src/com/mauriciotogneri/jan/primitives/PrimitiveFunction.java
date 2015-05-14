package com.mauriciotogneri.jan.primitives;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Operand;

public interface PrimitiveFunction
{
	void apply(Stack<Operand> stack);
}