# Exception

## Types

- **LBYL** : Look before you leap. use if condition to check the exception.
- **EAFP** : easy to ask for forgiveness and permissions. use try catch.
    - **Checked**: exception that are taken care during compile time. Else there will be compiled error.
    - **Unchecked**: unchecked exception that occurs during runtime.



## Multiple Exception

try () {}
catch (SQLException | ArithmeticException e) {}