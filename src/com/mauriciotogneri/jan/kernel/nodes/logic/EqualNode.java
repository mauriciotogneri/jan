package com.mauriciotogneri.jan.kernel.nodes.logic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.nodes.operations.BinaryNode;

import java.math.BigDecimal;
import java.util.List;

public class EqualNode extends BinaryNode
{
    public EqualNode(Token token)
    {
        super(token);
    }

    @Override
    protected boolean evaluate(BigDecimal operand1, BigDecimal operand2)
    {
        return equalNumbers(operand1, operand2);
    }

    @Override
    protected boolean evaluate(Boolean operand1, Boolean operand2)
    {
        return equalBooleans(operand1, operand2);
    }

    @Override
    protected boolean evaluate(String operand1, String operand2)
    {
        return equalStrings(operand1, operand2);
    }

    @Override
    protected boolean evaluate(List<Value> operand1, List<Value> operand2)
    {
        return equalLists(operand1, operand2);
    }
}