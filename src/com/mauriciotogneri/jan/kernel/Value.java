package com.mauriciotogneri.jan.kernel;

import java.math.BigDecimal;
import java.util.List;

public class Value
{
    private final Type type;
    private final Object value;

    public enum Type
    {
        NUMBER, BOOLEAN, STRING, LIST, UNDEFINED
    }

    private Value(Type type, Object value)
    {
        this.type = type;
        this.value = value;
    }

    public static Value asNumber(BigDecimal value)
    {
        return new Value(Type.NUMBER, value);
    }

    public static Value asString(String value)
    {
        return new Value(Type.STRING, value);
    }

    public static Value asBoolean(Boolean value)
    {
        return new Value(Type.BOOLEAN, value);
    }

    public static Value asList(List<Value> value)
    {
        return new Value(Type.LIST, value);
    }

    public boolean isNumber()
    {
        return type == Type.NUMBER;
    }

    public boolean isBoolean()
    {
        return type == Type.BOOLEAN;
    }

    public boolean isString()
    {
        return type == Type.STRING;
    }

    public boolean isList()
    {
        return type == Type.LIST;
    }

    public BigDecimal getNumber()
    {
        return (BigDecimal) value;
    }

    public boolean getBoolean()
    {
        return (Boolean) value;
    }

    public String getString()
    {
        return (String) value;
    }

    @SuppressWarnings("unchecked")
    public List<Value> getList()
    {
        return (List<Value>) value;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        printResult(this, builder);

        return builder.toString();
    }

    private void printResult(Value value, StringBuilder builder)
    {
        if (value.isNumber())
        {
            builder.append(value.getNumber());
        }
        else if (value.isBoolean())
        {
            builder.append(value.getBoolean());
        }
        else if (value.isString())
        {
            builder.append("\"");
            builder.append(value.getString());
            builder.append("\"");
        }
        else if (value.isList())
        {
            List<Value> list = value.getList();

            builder.append("[");

            for (int i = 0; i < list.size(); i++)
            {
                Value element = list.get(i);

                if (i != 0)
                {
                    builder.append(", ");
                }

                printResult(element, builder);
            }

            builder.append("]");
        }
    }
}