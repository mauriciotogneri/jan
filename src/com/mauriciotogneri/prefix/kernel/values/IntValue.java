package com.mauriciotogneri.prefix.kernel.values;

import com.mauriciotogneri.prefix.kernel.Value;

public class IntValue extends Value
{
	public final Long value;
	
	public IntValue(long value)
	{
		super(Type.INT);
		
		this.value = value;
	}
	
	@Override
	public Object getValue()
	{
		return this.value;
	}
}