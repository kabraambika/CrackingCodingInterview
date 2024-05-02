import java.util.*;

public class FaultServerDetection {
  public static void main(String[] args) {
    int n = 2;
    String[] logs = {"s1 error", "s1 error", "s2 error", "s1 error", "s1 error", "s2 success"};
    System.out.println(countFaults(n, logs)); // Output should be 1

    n = 5;
    String[] logs1 = {"s1 error", "s2 error", "s1 error", "s4 success", "s5 error", "s3 success", "s1 error"};
    System.out.println(countFaults(n, logs1)); // Output should be 1

    n = 1;
    String[] logs2 = {"s1 error", "s1 error", "s1 error"};
    System.out.println(countFaults(n, logs2)); // Output should be 1

    n = 1;
    String[] logs3 = {"s1 error", "s1 error", "s1 success"};
    System.out.println(countFaults(n, logs3)); // Output should be 0
  }

  public static int countFaults(int n, String[] logs){
    Map<String, Integer> errorCount = new HashMap<>();
    int replacedServersCount = 0;

    for(String log : logs){
      String[] parts = log.split(" ");
      String serverName = parts[0];
      String serverStatus = parts[1];
      errorCount.putIfAbsent(serverName, 0);

      if(validate(serverName, serverStatus, n, errorCount) && serverStatus.equals("error")){
        int count = errorCount.get(serverName) + 1;
        errorCount.put(serverName, count);
        if(count == 3){
          replacedServersCount++;
          errorCount.put(serverName, 0);
        }
      }
    }
    return replacedServersCount;
  }

  private static boolean validate(String name, String status, int n, Map<String, Integer> errorCount){
    return errorCount.size() <= n && errorCount.containsKey(name) && (status.equals("error") || status.equals("success"));
  }
}
