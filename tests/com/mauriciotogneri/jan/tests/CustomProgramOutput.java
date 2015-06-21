package com.mauriciotogneri.jan.tests;

import com.mauriciotogneri.jan.execution.output.ProgramOutput;
import com.mauriciotogneri.jan.kernel.Value;

public class CustomProgramOutput implements ProgramOutput
{
    public Value result = null;
    public String error = null;

    @Override
    public void processResult(Value result)
    {
        this.result = result;
        this.error = null;
    }

    @Override
    public void processError(String text)
    {
        this.error = text;
        this.result = null;
    }

    public boolean isValid()
    {
        return (result != null);
    }
}