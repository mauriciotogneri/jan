package com.mauriciotogneri.jan.primitive;

import java.util.Stack;
import com.mauriciotogneri.jan.kernel.Value;

public interface PrimitiveFunction
{
	void apply(Stack<Value> stack);
}