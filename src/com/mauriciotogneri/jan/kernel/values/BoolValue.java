package com.mauriciotogneri.jan.kernel.values;

import com.mauriciotogneri.jan.kernel.Value;

public class BoolValue extends Value
{
	public BoolValue(boolean value)
	{
		super(Type.BOOLEAN, value);
	}
}