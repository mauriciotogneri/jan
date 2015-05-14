package com.mauriciotogneri.jan.kernel.values;

import com.mauriciotogneri.jan.kernel.Value;

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