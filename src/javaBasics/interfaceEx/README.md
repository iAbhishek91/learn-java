# interface or class

> How to decide whether to implement an interface or extend  a class?

**Factor** to keep in mind

- interface can do multiple inheritance, but not class.
- we extend class when parent have some characteristics and that is to be inherited by child classes.
- we use interface for templating or defining a contract.

## Note on interface

Unlike abstract class, Interface har/are

Member variables cant be inherited from interface.
Member variables are `static final` in the interface.

Interface can't have `constructor`.

Interface methods are by default `public`.

Interface can't implement a method.

