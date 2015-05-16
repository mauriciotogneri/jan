package com.mauriciotogneri.jan.kernel.symbols;

import java.math.BigDecimal;

public abstract class Operand implements Symbol
{
	private final Type type;
	private final Object value;
	
	public enum Type
	{
		NUMBER, BOOLEAN, STRING, LIST, UNDEFINED;
	}
	
	public Operand(Type type, Object value)
	{
		this.type = type;
		this.value = value;
	}
	
	public boolean isNumber()
	{
		return this.type == Type.NUMBER;
	}
	
	public boolean isBoolean()
	{
		return this.type == Type.BOOLEAN;
	}
	
	public boolean isString()
	{
		return this.type == Type.STRING;
	}
	
	public BigDecimal getNumber()
	{
		return (BigDecimal)this.value;
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