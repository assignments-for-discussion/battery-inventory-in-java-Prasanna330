package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {  // return type of class CountBySoH
    CountsBySoH counts = new CountsBySoH();
    int sohper=0;                      
    for(int i=0;i<presentCapacities.length;i++)
      {
        sohper= 100*(presentCapacities[i]/120);      
        if(sohper>80 && sohper<=100)      // If the soh% value is greater than 80 upto 100         
          counts.healthy++;
        else if(sohper>=65 && sohper<=80)
        counts.exchange++;                // If the soh% value is greater than or equal to 65 and less than or equal to 80
        else
          counts.failed++;                // If the soh% value is lesser than 65
      }
    return counts;               
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};                 //Present capacity array
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert counts.healthy == 2;
    assert counts.exchange == 3;
    assert counts.failed == 1;
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {          //Main function
    testBucketingByHealth();
  }
}
