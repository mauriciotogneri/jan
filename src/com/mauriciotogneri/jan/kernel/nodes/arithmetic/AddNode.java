package com.mauriciotogneri.jan.kernel.nodes.arithmetic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.PrimitiveNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AddNode extends PrimitiveNode
{
    public AddNode(Token token)
    {
        super(token, 2);
    }

    @Override
    public Value evaluate(Context context)
    {
        Value operand1 = get(0, context);
        Value operand2 = get(1, context);

        if (operand1.isNumber() && operand2.isNumber())
        {
            BigDecimal value1 = operand1.getNumber();
            BigDecimal value2 = operand2.getNumber();

            return Value.asNumber(value1.add(value2));
        }
        else if (operand1.isString() && operand2.isString())
        {
            String value1 = operand1.getString();
            String value2 = operand2.getString();

            return Value.asString(value1 + value2);
        }
        else if (operand1.isList() && operand2.isList())
        {
            List<Value> value1 = operand1.getList();
            List<Value> value2 = operand2.getList();

            List<Value> result = new ArrayList<>();
            result.addAll(value1);
            result.addAll(value2);

            return Value.asList(result);
        }
        else if (operand1.isNumber() && operand2.isList())
        {
            BigDecimal value1 = operand1.getNumber();
            List<Value> value2 = operand2.getList();

            List<Value> result = new ArrayList<>();
            result.addAll(value2);
            result.add(Value.asNumber(value1));

            return Value.asList(result);
        }
        else if (operand1.isBoolean() && operand2.isList())
        {
            Boolean value1 = operand1.getBoolean();
            List<Value> value2 = operand2.getList();

            List<Value> result = new ArrayList<>();
            result.addAll(value2);
            result.add(Value.asBoolean(value1));

            return Value.asList(result);
        }
        else if (operand1.isString() && operand2.isList())
        {
            String value1 = operand1.getString();
            List<Value> value2 = operand2.getList();

            List<Value> result = new ArrayList<>();
            result.addAll(value2);
            result.add(Value.asString(value1));

            return Value.asList(result);
        }

        // TODO: explain more
        throw new RuntimeException("Cannot perform operation '" + token.lexeme + "' at: [" + token.line + ", " + token.column + "]");
    }
}