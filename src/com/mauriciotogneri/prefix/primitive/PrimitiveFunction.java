package com.mauriciotogneri.prefix.primitive;

import java.util.Stack;
import com.mauriciotogneri.prefix.kernel.Value;

public interface PrimitiveFunction
{
	void apply(Stack<Value> stack);
}