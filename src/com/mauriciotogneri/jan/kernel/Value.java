package com.mauriciotogneri.jan.kernel;

import java.math.BigDecimal;
import java.util.List;

public class Value
{
	private final Type type;
	private final Object value;
	
	public enum Type
	{
		NUMBER, BOOLEAN, STRING, LIST, UNDEFINED;
	}
	
	private Value(Type type, Object value)
	{
		this.type = type;
		this.value = value;
	}
	
	public static Value numberValue(BigDecimal value)
	{
		return new Value(Type.NUMBER, value);
	}
	
	public static Value stringValue(String value)
	{
		return new Value(Type.STRING, value);
	}
	
	public static Value booleanValue(Boolean value)
	{
		return new Value(Type.BOOLEAN, value);
	}
	
	public static Value listValue(List<Node> value)
	{
		return new Value(Type.LIST, value);
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
	
	public boolean isList()
	{
		return this.type == Type.LIST;
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
	
	@SuppressWarnings("unchecked")
	public List<Node> getList()
	{
		return (List<Node>)this.value;
	}
}