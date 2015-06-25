# Jan

<img align="right" src="http://i.imgur.com/Q4fvRk0.png">

**Jan** is a purely functional programming language with an ultra minimalist syntax. It is named after **Jan Łukasiewicz**, a Polish logician and philosopher creator of the **Polish notation**, also known as **Prefix notation**, which is a form of notation for logic, arithmetic and algebra. The distinguishing feature of this language is that it places operators to the left of their operands. Given that the arity of the operators and functions in the language is fixed, the result is a syntax lacking parentheses or other brackets that can still be parsed without ambiguity. Although **Jan** is a general purpose language, it is mostly intended to be used as a tool for learning functional programming.

## Table of Contents

- [Characteristics](#characteristics)
- [Syntax](#syntax)
    - [Functions](#functions)
    - [Expressions](#expressions)
- [Operators](#operators)
    - [Arithmetic](#arithmetic)
    - [Comparison](#cComparison)
    - [Logical](#logical)
    - [Conditional](#conditional)
    - [String](#string)
    - [List](#list)
    - [Import](#import)
    - [Comments](#comments)
    - [Anonymous expression](#anonymous-expression)
- [Types](#types)
    - [Numbers](#numbers)
    - [Booleans](#booleans)
    - [Strings](#strings)
    - [Lists](#lists)
- [Execution](#execution)
- [Examples](#examples)
- [TODO](#todo)

## Characteristics

The language has the following characteristics:

* Purely functional
* All functions and operands use prefix notation
* Interpreted
* Case sensitive
* There are no reserved words

## Syntax

A _program_ written in **Jan** consists of a set of functions. A _function_ consists of a set of expressions that are evaluated sequentially. An _expression_ is a combination of explicit constants, parameters, operators and functions that are evaluated to return a value (or an empty result). The language follows the _off-side_ rule to define its syntax (i.e., blocks are expressed by indentation marks). A **Jan** script should have a **.jan** extension.

### Functions

Functions in **Jan** have a name (unique within the program), a list of parameters (if any) and a list of expressions that will be evaluated sequentially. When a function is called, the interpreter evaluates the expressions in the order that they were defined. If an expression returns a value (i.e., it does not return an empty result), the function finishes and the result of that expression is returned.

Function template:

```
FUNCTION_NAME PARAMETER_1 PARAMETER_2 PARAMETER_3...
    EXPRESSION_1
    EXPRESSION_2
    EXPRESSION_3
    ...
```

Notice that the expressions are indented using the tab character and the formal parameters are not separated by commas but by a whitespace.

Here is an example function that compares 2 numbers:

```common-lisp
compare a b
    ? > a b "A is bigger than B"
    ? > b a "B is bigger than A"
    "A and B are equal"
```

In pseudocode it could be written as:

```pascal
function compare (a, b)
    if (a > b) then
        return "A is bigger than B"
    else if (b > a) then
        return "B is bigger than A"
    else
        return "A and B are equal"
    end if
end
```

### Expressions

There are two types of expressions:

* _Non-Conditional_: these expressions are evaluated and returned as a result.
* _Conditional_: these expressions evaluate a condition in order to determine if a value is returned or not. There are two types of conditional expressions:

_Simple_: the condition is evaluated and if it is true, the expression returns a value, otherwise the execution continues to the next expression.

Example:

```common-lisp
? = n 0 "N is zero"
```

The previous expression can be read as: _if n is equal to zero then return the string "N is zero"_

In pseudocode it could be written as:

```pascal
if (n == 0) then
    return "N is zero"
end if
```

_Complex_: the condition is evaluated and if it is true, the expression returns the result of the consequent value, otherwise it returns the result of the alternative value.

Example:

```common-lisp
?? = n 0 "N is zero" "N is not zero"
```

The previous expression can be read as: _if n is equal to zero then return the string "N is zero", otherwise return the string "N is not zero"_

In pseudocode it could be written as:

```pascal
if (n == 0) then
    return "N is zero"
else
    return "N is not zero"
end if
```

All functions must contain at least one expression and the last (and only the last) expression in the list must be:

* A non-conditional expression
* A complex conditional expression

Expressions must be written using **prefix notation** (i.e., operators are placed to the left of the operands) and there must be at least one whitespace between operators and operands.

## Operators

**Jan** contains a set of built-in operators to be used within expressions:

### Arithmetic

The language supports the following arithmetic operators:

* Addition: ``+``
    * Example: ``+ a b``

* Subtraction: ``-``
    * Example: ``- a b``

* Multiplication: ``*``
    * Example: ``* a b``

* Division: ``/``
    * Example: ``/ a b``

* Increment: ``++``
    * Example: ``++ a``

* Decrement: ``--``
    * Example: ``-- a``

* Exponentiation: ``^``
    * Example: ``^ a b``

* Modulus: ``%``
    * Example: ``% a b``

All the arithmetic operators receive numbers as input and return a number as a result.

### Comparison

The language supports the following comparison operators:

* Equal: ``=``
    * Example: ``= a b``

* Not equal: ``!=``
    * Example: ``!= a b``

These two comparison operators receive either two numbers, two booleans, two strings or two lists as input and return a boolean as a result.

* Less: ``<``
    * Example: ``< a b``

* Less or equal: ``<=``
    * Example: ``<= a b``

* Greater: ``>``
    * Example: ``> a b``

* Greater or equal: ``>=``
    * Example: ``>= a b``

The rest of comparison operators receive two numbers as input an return a boolean as a result.

### Logical

The language supports the following logical operators:

* And: ``&``
    * Example: ``& a b``

* Or: ``|``
    * Example: ``| a b``

* Negation: ``!``
    * Example: ``! a``

All logical operators receive booleans as input and return a boolean as a result.

### Conditional

The language supports the following conditional operators:

* Simple conditional: ``?``
    * Example: ``? a b`` (_if **a** then **b**_)

* Complex conditional: ``??``
    * Example: ``?? a b c`` (_if **a** then **b** else **c**_)

In both conditional operators, the result of evaluating the first expression (in the examples: **a**) must be a boolean value.

### String

The language supports the following string operators:

* Definition: ``""``
    * Example: ``"This is an example"``

* Indexation: ``@``
    * Example: ``@ 7 "Hello, world!"`` (it returns the 8th character in the string, in the example: **w**)

* Removal: ``~``
    * Example: ``~ 5 "Do not test me"`` (it removes the 6th character in the string, in the example: **"Do no test me"**)

* Length: ``#``
    * Example: ``# "The cake is a lie"`` (it returns the length of the string, in the example: **17**)

* Concatenation: ``+``
    * Example: ``+ "Keep it simple " "and short"`` (it concatenates the two strings, in the example: **"Keep it simple and short"**)

### List

The language supports the following list operators:

* Definition: ``[]``
    * Example: ``[ 1 2 3 ]`` (notice that there must be a whitespace between the brackets and the first and last element)

* Indexation: ``@``
    * Example: ``@ 2 [ a b c d e ]`` (it returns the 3rd element of the list, in the example: **c**)

* Removal: ``~``
    * Example: ``~ 3 [ a b c d e ]`` (it removes the 4th element of the list, in the example: **[ a b c e ]**)

* Length: ``#``
    * Example: ``# [ a b c ]`` (it returns the length of the list, in the example: **3**)

* Concatenation: ``+``
    * Example: ``+ z [ x y ]`` (it concatenates the element to the end of the list, in the example: **[ x y z ]**)

### Import

A program can import another program located in a file using the ``$`` symbol. For example:

```
$ "libs/math.jan"
$ "utils/vectors.jan"
$ "physics.jan"
```

The path of the files can be expressed as relative (to the current program) or absolute.

### Comments

The language allows in-line comments using the ``;`` symbol. For example:

```common-lisp
even n ; returns true if n is an even number
	= 0 % n 2
```

### Anonymous function

The language allows to define one (and only one) anonymous function and in case of exist, it  will be called after the script is completely parsed. The anonymous function does not have a name or parameters and it must contain one (and only one) expression (non-conditional or complex). For example:

```common-lisp
\ + "Result: " compute 10
```

## Types

The language has the following data types:

### Numbers

There are two types of numbers:

_Integers_: whole numbers expressed in base 10, for example:

``42``   ``-8``   ``250``   ``0``   ``-67``

_Floats_: decimal numbers expressed in base 10, for example:

``12.34``   ``-0.001``   ``2.0``   ``99.90``   ``-50.71``

Notice that floats should be expressed like this ``0.123`` instead of ``.123``

### Booleans

Boolean constants are defined as:

* True: ``.`` (dot)
* False: ``:`` (semicolon)

### Strings

Strings are immutable sequences of characters and therefore, operations such as _removal_ and _concatenation_ do not affect the given string but return a new one as a consequence of applying the operator. String constants are defined using double quotes, for example:

``"First, solve the problem. Then, write the code."``

### Lists

Lists are fixed-length arrays that can contain zero or more elements. Lists are immutable elements and therefore, operations such as _removal_ and _concatenation_ do not affect the given list but return a new one as a consequence of applying the operator. Lists can contain elements of different types and are defined using the brackets symbols: ``[`` ``]``. For example:

``[ 1 2 3 4 5 ]``

## Execution

## Examples

# TODO

* Exit with error { “ERROR” }
* Print value for debug ( + "N: " n )
* Implement let, cache values and use lazy evaluation _ foo + 1 2
* Implement imports
* Implement list range:  .. 1 4 [ a b c d e f g h ] (from 1 take 4 elements)  =>   [ b c d e ]
* Finish semantic validation
* Finish lazy evaluation (when @ or # do not evaluate all list)
* Accept numbers in scientific notation 0.123e+10
* Curryfication
* Pass functions as parameters