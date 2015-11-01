package com.mauriciotogneri.jan.bytecode;

import java.io.IOException;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Compiler
{
    public static void main(String[] args)
    {
        //        try
        //        {
        //            compile("./MyClass.java");
        //        }
        //        catch (IOException e)
        //        {
        //            e.printStackTrace();
        //        }
    }

    private static void compile(String filePath) throws IOException
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(filePath);
        CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
        task.call();
        fileManager.close();
    }
}
