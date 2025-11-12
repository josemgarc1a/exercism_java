import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CalculatorConundrum {

    private static final Set<String> VALID_OPERATIONS = Set.of("+","*","/");
    private static final String message = "%s %s %s = %s";

    public String calculate(int operand1, int operand2, String operation) {
        validateOperation(operation);
        int result = 0;
         
        switch (operation) {
            case "+":
                result = addition(operand1, operand2);
                break;
            case "*":
                result = multiplication(operand1, operand2);
                break;
            case "/":
                try {
                    result = division(operand1, operand2);    
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
                
                break;
            default:
                throw new IllegalOperationException("Unknown operation: " + operation);
        }

        return String.format(message, operand1, operation, operand2, result);
    }

    private void validateOperation(String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        } else if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        } else if(!VALID_OPERATIONS.contains(operation)) {
            throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        }
    }

    private int addition(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int multiplication(int operand1, int operand2){
        return operand1*operand2;
    }

    private int division(int operand1, int operand2){
        return operand1/operand2;
    }
    
}
