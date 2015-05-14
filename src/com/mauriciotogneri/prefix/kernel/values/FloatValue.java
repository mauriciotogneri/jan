package com.mauriciotogneri.prefix.kernel.values;

import com.mauriciotogneri.prefix.kernel.Value;

public class FloatValue extends Value
{
	public final Double value;
	
	public FloatValue(double value)
	{
		super(Type.FLOAT);
		
		this.value = value;
	}
	
	@Override
	public Object getValue()
	{
		return this.value;
	}
}