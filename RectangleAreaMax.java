import java.util.*;

public class RectangleAreaMax {

  public static void main(String[] args) {
    int r = maxSumArea(new int[]{1,1,2,2,3,3,4,5});
    System.out.println(r);

    int r1 = maxSumArea(new int[]{9,9,9,9,8,8,7,7,6,6,6,5,4});
    System.out.println(r1);

    int r2 = maxSumArea(new int[]{2,3,3,4,6,8,8,6});
    System.out.println(r2);
  }

  public static int maxSumArea(int[] sideLengths){
    int result = 0;

    Map<Integer, Integer> freq = new TreeMap<>(Collections.reverseOrder());
    Set<Integer> uniqueSide = new HashSet<>();
    for(int side : sideLengths){
      if(!uniqueSide.contains(side)){
        uniqueSide.add(side);
      }
      freq.put(side, freq.getOrDefault(side, 0)+1);
    }
    Map<Integer, Integer> pairMap = new TreeMap<>(Collections.reverseOrder());
    for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
      int sideNum = entry.getKey();
      int sideFreq = entry.getValue();

      if(sideFreq % 2 == 0){
        pairMap.put(sideNum, sideFreq / 2);
      }
      else {
        int qu = sideFreq / 2;
        if(qu > 0) {
          pairMap.put(sideNum, sideFreq / 2);
        }
        if(uniqueSide.contains(sideNum - 1)){
          freq.put(sideNum - 1, freq.get(sideNum - 1) + 1);
        }
      }
    }
    System.out.println(pairMap);

    List<Integer> rem = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : pairMap.entrySet()){
      if(entry.getValue() % 2 != 0){
        rem.add(entry.getKey());
        if(entry.getValue() / 2 > 0){
          result += Math.pow(entry.getKey(), entry.getValue()-1);
        }
      }
      else {
        result += Math.pow(entry.getKey(), entry.getValue());
      }
    }

    for(int i = 0; i < rem.size(); i++){
      result += rem.get(i) * rem.get(i+1);
      i++;
    }
    return result;
  }
}
