package com.mauriciotogneri.jan.execution.output;

import com.mauriciotogneri.jan.kernel.Value;

public interface ProgramOutput
{
    void processResult(Value result);

    void processError(String text);
}