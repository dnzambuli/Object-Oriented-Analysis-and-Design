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

