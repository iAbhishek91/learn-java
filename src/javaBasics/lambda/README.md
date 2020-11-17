# Lambda

Lambda expression are used to keep our code short and clean.

Target should be an Interface and not a class.

Can be assigned as a variable of type interface.

## Syntax

same as arrow functions

```java
()-> {}
```
Every lambda has three sections. 

1. argument list; ()
    - `type` are not required.
    - `bracket` are not required in case of single args
2. arrow character; ->
3. body; {}, 
    - for single line skip the `curly braces`.
    - `return` keyword is not required if single line.

## How it works

- Basically it will create new functional shorthand to replace an anonymous object with method overloading.
- Based on the parameter it decides which interface to implement.
- Lambda only works with any interface which have only one method to implement of same signature excluding name. Ref: MyInterface example.

## Functional interfaces

Are interfaces which can be used as Lambda.

##  Scope

Just like in javascript, arrow function to not have this, lambda also do not have.

They have the same scope as parent class. try `getClass().getSimpleName()`

## Helper methods

These methods were introduced as part of 1.8 in `java.util.function`, to support functional programming and lamda.

### forEach

### Predicate

Predicate states the subject or condition.

we can pass a condition and test for any condition. ref: filter example

There are different type of predicate: `IntPredicate`, `DoublePredicate`. ref: DifferentPredicate

Predicate can be chained. ref: chainPredicate

### Supplier

Do not accept a parameter but returns value.

Again there are several types of Suppliers like Predicates.

### Function

define a custom function which accepts parameters and return value.

Again like predicate and supplier there are different type of functions. `intoLong` etc.

`BiFunction` is another interface which accept multiple arguments.

`Unary operator` extends function interface

These interfaces accept parameter and returns value but both should be of same type.

## Stream

Are chainable actions that we can perform.

There are popular function defined like: `filter`, `sort`, `map` `forEach` `reduce`, `collect`. ref: streamsEx

Stream are executed lazily. It will work only if there is a termination operation.