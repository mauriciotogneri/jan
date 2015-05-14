package com.mauriciotogneri.prefix.kernel;


public abstract class Value implements ExpressionElement
{
	public final Type type;
	
	public enum Type
	{
		INT, FLOAT, BOOLEAN, STRING, LIST, UNDEFINED;
	}
	
	public Value(Type type)
	{
		this.type = type;
	}
	
	public boolean isInt()
	{
		return this.type == Type.INT;
	}
	
	public boolean isFloat()
	{
		return this.type == Type.FLOAT;
	}
	
	public boolean isNumber()
	{
		return isInt() || isFloat();
	}
	
	public long getInt()
	{
		Long value = (Long)getValue();
		
		return value.longValue();
	}
	
	public double getFloat()
	{
		Double value = (Double)getValue();
		
		return value.doubleValue();
	}
	
	protected abstract Object getValue();
}