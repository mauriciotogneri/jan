package com.mauriciotogneri.jan.kernel.symbols;

public abstract class Operand implements Symbol
{
	private final Type type;
	private final Object value;
	
	public enum Type
	{
		INT, FLOAT, BOOLEAN, STRING, LIST, UNDEFINED;
	}
	
	public Operand(Type type, Object value)
	{
		this.type = type;
		this.value = value;
	}
	
	public boolean isInt()
	{
		return this.type == Type.INT;
	}
	
	public boolean isFloat()
	{
		return this.type == Type.FLOAT;
	}
	
	public boolean isBoolean()
	{
		return this.type == Type.BOOLEAN;
	}
	
	public boolean isString()
	{
		return this.type == Type.STRING;
	}
	
	public boolean isNumber()
	{
		return isInt() || isFloat();
	}
	
	public long getInt()
	{
		return (Long)this.value;
	}
	
	public double getFloat()
	{
		return (Double)this.value;
	}
	
	public boolean getBoolean()
	{
		return (Boolean)this.value;
	}
	
	public String getString()
	{
		return (String)this.value;
	}
}