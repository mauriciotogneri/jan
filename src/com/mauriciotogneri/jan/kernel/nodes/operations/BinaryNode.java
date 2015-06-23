package com.mauriciotogneri.jan.kernel.nodes.operations;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

import java.math.BigDecimal;
import java.util.List;

public abstract class BinaryNode extends PrimitiveNode
{
    protected BinaryNode(Token token)
    {
        super(token, 2);
    }

    @Override
    public Value evaluate(Context context)
    {
        Value operand1 = get(0, context);
        Value operand2 = get(1, context);

        if (operand1.isBoolean() && operand2.isBoolean())
        {
            Boolean value1 = operand1.getBoolean();
            Boolean value2 = operand2.getBoolean();

            return Value.asBoolean(evaluate(value1, value2));
        }
        else if (operand1.isNumber() && operand2.isNumber())
        {
            BigDecimal value1 = operand1.getNumber();
            BigDecimal value2 = operand2.getNumber();

            return Value.asBoolean(evaluate(value1, value2));
        }
        else if (operand1.isString() && operand2.isString())
        {
            String value1 = operand1.getString();
            String value2 = operand2.getString();

            return Value.asBoolean(evaluate(value1, value2));
        }
        else if (operand1.isList() && operand2.isList())
        {
            List<Value> value1 = operand1.getList();
            List<Value> value2 = operand2.getList();

            return Value.asBoolean(evaluate(value1, value2));
        }

        // TODO: explain more
        throw new RuntimeException("Cannot perform operation '" + token.lexeme + "' at: [" + token.line + ", " + token.column + "]");
    }

    protected boolean equalNumbers(BigDecimal operand1, BigDecimal operand2)
    {
        return (operand1.compareTo(operand2) == 0);
    }

    protected boolean equalBooleans(Boolean operand1, Boolean operand2)
    {
        return (operand1.booleanValue() == operand2.booleanValue());
    }

    protected boolean equalStrings(String operand1, String operand2)
    {
        return (operand1.equals(operand2));
    }

    protected boolean equalLists(List<Value> operand1, List<Value> operand2)
    {
        if (operand1.size() == operand2.size())
        {
            for (int i = 0; i < operand1.size(); i++)
            {
                Value value1 = operand1.get(i);
                Value value2 = operand2.get(i);

                if (!equalValues(value1, value2))
                {
                    return false;
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean equalValues(Value operand1, Value operand2)
    {
        if (operand1.isNumber() && operand2.isNumber())
        {
            BigDecimal value1 = operand1.getNumber();
            BigDecimal value2 = operand2.getNumber();

            return evaluate(value1, value2);
        }
        else if (operand1.isBoolean() && operand2.isBoolean())
        {
            Boolean value1 = operand1.getBoolean();
            Boolean value2 = operand2.getBoolean();

            return evaluate(value1, value2);
        }
        else if (operand1.isString() && operand2.isString())
        {
            String value1 = operand1.getString();
            String value2 = operand2.getString();

            return evaluate(value1, value2);
        }
        else if (operand1.isList() && operand2.isList())
        {
            List<Value> value1 = operand1.getList();
            List<Value> value2 = operand2.getList();

            return evaluate(value1, value2);
        }
        else
        {
            return false;
        }
    }

    protected abstract boolean evaluate(BigDecimal operand1, BigDecimal operand2);

    protected abstract boolean evaluate(Boolean operand1, Boolean operand2);

    protected abstract boolean evaluate(String operand1, String operand2);

    protected abstract boolean evaluate(List<Value> operand1, List<Value> operand2);
}