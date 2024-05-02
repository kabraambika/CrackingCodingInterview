import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * The Calculator class is defined to encapsulate the calculator functionality.
 */
public class Calculator {
  private Stack<Double> stack;
  private Map<String, BiFunction<Double, Double, Double>> binaryOperators;
  private Map<String, Function<Double, Double>> unaryOperators;

  /**
   * The constructor initializes an empty stack (stack) to store the operands and a HashMap (operators)
   * that maps the operator symbols to their corresponding lambda functions using BiFunction interface.
   */
  public Calculator() {
    stack = new Stack<>();
    binaryOperators = new HashMap<>();
    binaryOperators.put("+", (a, b) -> a + b);
    binaryOperators.put("-", (a, b) -> a - b);
    binaryOperators.put("*", (a, b) -> a * b);
    binaryOperators.put("/", (a, b) -> a / b);
    binaryOperators.put("avg", (a, b) -> (a + b) / 2);

    unaryOperators = new HashMap<>();
    unaryOperators.put("neg", a -> -a);

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
      if (binaryOperators.containsKey(token)) {
        performBinaryOperation(token);
      } else if (unaryOperators.containsKey(token)) {
        performUnaryOperation(token);
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
  private void performBinaryOperation(String operator) {
    if (stack.size() < 2) {
      throw new IllegalArgumentException("Insufficient operands for the operation");
    }

    double rightOperand = stack.pop();
    double leftOperand = stack.pop();
    double result = binaryOperators.get(operator).apply(leftOperand, rightOperand);
    stack.push(result);
  }

  /**
   * The performUnaryOperation method retrieves the top operand from the stack,
   * applies the corresponding unary operation using the Function stored in the unaryOperators map,
   * and pushes the result back onto the stack.
   * @param operator sign in string
   */
  private void performUnaryOperation(String operator) {
    if (stack.isEmpty()) {
      throw new IllegalArgumentException("Insufficient operands for the operation");
    }

    double operand = stack.pop();
    double result = unaryOperators.get(operator).apply(operand);
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

    // Negative operation
    String[] negativeExpression = {"5", "neg"};
    double negativeResult = calculator.evaluate(negativeExpression);
    System.out.println(negativeResult);  // Output: -5.0

    // Average operation
    String[] averageExpression = {"10", "20", "avg"};
    double averageResult = calculator.evaluate(averageExpression);
    System.out.println(averageResult);  // Output: 15.0
  }
}
