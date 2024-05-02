import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * The Calculator class is defined to encapsulate the calculator functionality.
 */
public class Calculator {
  private Stack<Double> stack;
  private Map<String, BiFunction<Double, Double, Double>> operators;

  /**
   * The constructor initializes an empty stack (stack) to store the operands and a HashMap (operators)
   * that maps the operator symbols to their corresponding lambda functions using BiFunction interface.
   */
  public Calculator() {
    stack = new Stack<>();
    operators = new HashMap<>();
    operators.put("+", (a,b) -> a + b);
    operators.put("-", (a,b) -> a - b);
    operators.put("*", (a,b) -> a * b);
    operators.put("/", (a,b) -> a / b);

  }

  /**
   * The evaluate method takes the input expression as an array of strings and processes each token:
   *
   * If the token is an operator (exists in the operators map), it calls the performOperation method to apply the operation to the top two operands from the stack.
   * If the token is not an operator, it assumes it is an operand and converts it to a double using Double.parseDouble before pushing it onto the stack.
   *
   * @param expression array of strings for operations
   * @return result in double
   */
  public double evaluate(String[] expression) {
    for (String token : expression) {
      if (operators.containsKey(token)) {
        performOperation(token);
      } else {
        stack.push(Double.parseDouble(token));
      }
    }

    // After processing all the tokens, if the stack has exactly one element,
    // it represents the final result, which is returned.
    // Otherwise, an IllegalArgumentException is thrown indicating an invalid expression.
    if (stack.size() != 1) {
      throw new IllegalArgumentException("Invalid expression");
    }

    return stack.pop();
  }

  /**
   * The performOperation method retrieves the top two operands from the stack,
   * applies the corresponding operation based on the operator symbol
   * using the BiFunction stored in the operators map, and pushes the result back onto the stack.
   * @param operator sign in string
   */
  private void performOperation(String operator) {
    if (stack.size() < 2) {
      throw new IllegalArgumentException("Insufficient operands for the operation");
    }

    double rightOperand = stack.pop();
    double leftOperand = stack.pop();
    double result = operators.get(operator).apply(leftOperand, rightOperand);
    stack.push(result);
  }

  /**
   * The main method demonstrates how to create an instance of the Calculator class,
   * provide an expression as an array of strings, and evaluate the result.
   * @param args an array of strings
   */
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    String[] expression = {"16", "5", "*"};
    double result = calculator.evaluate(expression);
    System.out.println(result);  // Output: 21.0
  }
}
