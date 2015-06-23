# Jan

<img align="right" src="http://i.imgur.com/Q4fvRk0.png">

**Jan** is a purely functional programming language with an ultra minimalist syntax. It is named after **Jan Łukasiewicz**, a Polish logician and philosopher creator of the **Polish notation**, also known as **Prefix notation**, which is a form of notation for logic, arithmetic and algebra. The distinguishing feature of this language is that it places operators to the left of their operands. Given that the arity of the operators and functions in the language is fixed, the result is a syntax lacking parentheses or other brackets that can still be parsed without ambiguity. Although **Jan** is a general purpose language, it is mostly intended to be used as a tool for learning functional programming.

## Characteristics

The language has the following characteristics:

* Purely functional
* All functions and operands use prefix notation
* Interpreted
* Case sensitive
* There are no reserved words

## Syntax

A _program_ written in **Jan** consists of a set of functions. A _function_ consists of a set of expressions that are evaluated sequentially. An _expression_ is a combination of explicit constants, parameters, operators and functions that are evaluated to return a value (or an empty result). **Jan** follows the off-side rule to define its syntax (i.e., blocks in the language are expressed by its indentation).

### Functions

Functions in **Jan** have a name, a list of parameters (if any) and a list of expressions that will be evaluated sequentially. When a function is called, the interpreter will evaluate the expressions in the order that they were defined. If an expression returns a value (i.e., it doesn't return an empty result), the functions finishes and the result of that expression is returned.

Template:

```common-lisp
FUNCTION_NAME [PARAMETER_1 PARAMETER_2 PARAMETER_3 ...]
    EXPRESSION_1
    EXPRESSION_2
    EXPRESSION_3
    ...
```

Notice that the expressions are indented using the tab character and the formal parameters are not separated by commas.

Here is an example function that compares 2 numbers:

```common-lisp
compare a b
    ? > a b "A is bigger than B"
    ? > b a "B is bigger than A"
    "A and B are equal"
```

In pseudocode it could be written as:

```pascal
function max (a, b)
    if (a > b)
        return "A is bigger than B"
    else if (b > a)
        return "B is bigger than A"
    else
        return "A and B are equal"
end
```

### Expressions

There are two types of expressions:

* Non-Conditional: these expressions are evaluated and returned as a result.
* Conditional: these expressions evaluate a condition in order to determine if a value is returned or not. There are two types of conditional expressions:

Simple: the condition is evaluated and if it's true, the expression returns a value, otherwise the execution continues to the next expression.

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

Complex: the condition is evaluated and if it's true, the expression returns the result of the consequent value, otherwise it returns the result of the alternative value.

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

All functions in **Jan** must contain at least one expression and the last (and only the last) expression in the list must be:.

* A non-conditional expression
* A complex conditional expression
* An error expression

Expressions must be written in **prefix notation** (i.e., operators are placed to the left of the operands).

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

These two comparison operators receive either two numbers, two booleans or two strings as input and return a boolean as a result.

* Less: ``<``
    * Example: ``< a b``

* Less equal: ``<=``
    * Example: ``<= a b``

* Greater: ``>``
    * Example: ``> a b``

* Greater equal: ``>=``
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

``? ??``

* Simple conditional: ``?``
    * Example: ``? a b`` (_if a then b_)

* Complex conditional: ``??``
    * Example: ``?? a b c`` (_if a then b else c_)

In both conditional operators, the result of evaluating the first expression (in the examples: **a**) must be a boolean value.

### String

The language supports the following string operators:

* Definition: ``""``
    * Example: ``"This is an example"``

* Indexation: ``@``
    * Example: ``@ 4 "Hello, world!"`` (it returns the 5rd character in the string, in the example: **o**)

* Length: ``#``
    * Example: ``# "The cake is a lie"`` (it returns the length of the string, in the example: **17**)

* Concatenation: ``+``
    * Example: ``+ "Keep it simple " "and short"`` (it concatenates the two strings, in the example: **"Keep it simple and short"**)

### List

The language supports the following list operators:

* Definition: ``[]``
    * Example: ``[ 1 2 3 ]`` (notice that there must be a space between the brackets and the first and last element)

* Indexation: ``@``
    * Example: ``@ 2 [ a b c d e]`` (it returns the 3rd element of the list, in the example: **c**)

* Length: ``#``
    * Example: ``# [ a b c ]`` (it returns the length of the list, in the example: **3**)

* Concatenation: ``+``
    * Example: ``+ z [ x y ]`` (it concatenates to the end the element in to list, in the example: **[ x y z ]**)

### Import

``$``

### Comments

``;``

### Anonymous expression

``\``

## Types

Jan has the following data types:

### Numbers

Integers: whole numbers expressed in base 10, for example:

``42     -8     250    0     -67``

Floats: decimal numbers expressed in base 10, for example:

``12.34     -0.001     2.0     99.90     -50.71``

Notice that floats should be expressed like this ``0.123`` instead of ``.123``

### Booleans

.			true
:			false
! > 2 3		true

### Strings

### Lists

# TODO

* Lazy evaluation for @ or # (don't evaluate all list)
* Exit with error { “ERROR” }
* Print value for debug ( n )
* Implement let, cache values and use lazy evaluation _ foo + 1 2
* Finish semantic validation
* Finish lazy evaluation
* Accept numbers in scientific notation 0.123e+10
* Curryfication
* Pass functions as parameters