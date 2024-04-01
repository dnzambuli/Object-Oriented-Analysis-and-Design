# Breakdown of Basic Program

Java code `must` be inside a **class**

## Java Class
Java classes have names that begin in `capital letters`.

`Remember:` Java is case sensitive 
- Myclass
- myclass

Are different things

## Java files 

File names must match the class name therefore a file:

```
FileName.java
```

will have a class

```java
public class FileName{

}
```

## Main Method

```java
public static void main(String[] args){
    // code here;
}
```

any code inside the `main() **method**`  will be executed.

`System.out.println` is used to display output on the console

## Output

```java
println(); \\ prints a sentence **with** trailing newline character
print(); \\ prints a sentence **without** trailing newline 
```

## Comments

sections of the code that are ignored when code is compiled and interpreted into byte code

### Inline comment
only appear for as long as a new line is not selected

```java
// this is an inline comment
```

### Multiline comment
obscures multiple lines of code. 

They are mostly used for documenting code

```java
/* The code below will print the words Hello World
to the screen, and it is amazing */
System.out.println("Hello World");
```

# Java Variables
Variables are containers for storing data values.

In Java, there are different types of variables, for example:

`String` - stores text, such as "Hello". **String values are surrounded by double quotes**
`int` - stores integers (whole numbers), **without decimals**, such as 123 or -123
`float` - stores floating point numbers, **with decimals**, such as 19.99 or -19.99
`char` - stores single characters, such as 'a' or 'B'. **Char values are surrounded by single quotes**
`boolean` - stores values with two **states**: true or false

## Declaring (creating) Variables

```java
type variableName = value;
```

## Constant Variables

These are variables that can not be overwritten

They use the keyword `final` to indicate unchangeable

```java
final float gravity = 9.81; // the constant of gravity on earth
```

## Printing and Declaring Variables

System.out.println() allows for printing of all outputs

```java
int a, b, c;
a = b = c = 50; // all the variables are equated to 50
```

## Primitive Data Types
|Data Type|Size|Description|
|:----|:---:|:-----|
|byte|1 byte|Stores whole numbers from `-128 to 127`|
|short|	2 bytes|Stores whole numbers from `-32,768 to 32,767`|
|int|4 bytes|Stores whole numbers from `-2,147,483,648 to 2,147,483,647`|
|long|8 bytes|Stores whole numbers from `-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807`|
|float|4 bytes|Stores fractional numbers. Sufficient for storing `6 to 7 decimal digits`|
|double|8 bytes|Stores fractional numbers. Sufficient for storing `15 decimal digits`|
|boolean|1 bit|Stores true or false values|
|char|2 bytes|Stores a single character/letter or ASCII values|

## Type Casting

### Widening Casting

This is casting a smaller size type to a larger size type 

`byte` -> `short` -> `char` -> `int` -> `long` -> `float` -> `double`

```java
short myInt = 9;
double larger = myInt; // outputs 9.0
```

### Narrow Casting

Converting larger types to a smaller type

```java
double myDouble = 9.78d;
int myInt = (int) myDouble; // outputs 9 
```

