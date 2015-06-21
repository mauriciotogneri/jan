package com.mauriciotogneri.jan.execution.output;

import com.mauriciotogneri.jan.kernel.Value;

public class DefaultProgramOutput implements ProgramOutput
{
    @Override
    public void processResult(Value result)
    {
        System.out.print(result.toString());
    }

    @Override
    public void processError(String text)
    {
        System.err.print(text);
    }
}