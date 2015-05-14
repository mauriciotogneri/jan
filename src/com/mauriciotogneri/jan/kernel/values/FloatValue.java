package com.mauriciotogneri.jan.kernel.values;

import com.mauriciotogneri.jan.kernel.Value;

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