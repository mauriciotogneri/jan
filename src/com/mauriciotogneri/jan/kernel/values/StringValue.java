package com.mauriciotogneri.jan.kernel.values;

import com.mauriciotogneri.jan.kernel.Value;

public class StringValue extends Value
{
	public StringValue(String value)
	{
		super(Type.STRING, value);
	}
}