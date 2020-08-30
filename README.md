# Feature Gating Module

## Algorithm for Condition Evaluation

We divide the evaluation into multiple phases. As explained below.
using these phases we can handle multiple kinds of errors and 
make each phase independent of another.


### 1. Element Parser

    1. Determines the Element(tokens)
    2. Classifies tokens as separators, operands (constants,lookups) and operators.
  
    Thrown Errors:
        * Invalid Token
 
### 2. User operand substitution.
    1. Check if user operand exists
    2. Substitute the value in Elements list.
    
    Thrown Errors:
        * Unknown user property
        
### 3. PostFix conversion phase.
    Use stack to convert the PostFix
    
    Throw Errors:
        * InvalidNumberOfOperands 
        
### 4. Evaluate the PostFix expression.
    Evalutes the PostFix Expression 
    
    Throw Errors:
        * EvaluationError 
