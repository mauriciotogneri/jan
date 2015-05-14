package com.mauriciotogneri.prefix;

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