package ru.stqa.pft.sandbox;

public class Primes {
  public static boolean isPrime(int n){
    //tip int -eto 32 bitnye chisla
    for (int i=2; i<n; i+=1){
      //sokrashennaya ot i=i+1 est i+=1 ili i++ gde "++"-inkriment,uvelichenie peremennoy na edenicu
      //konstrukciya "for" dlya opisaniya cikla
      if (n%i ==0){
        //% - operaciya polucheniya ostatok ot deleniya
        return false;
      }
    }
    return true;
  }
  public static boolean isPrimeFast(int n){
   int m= (int)Math.sqrt(n);
    for (int i=2; i<m; i+=1){
      if (n%i ==0){
        return false;
      }
    }
    return true;
  }
  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n) {
      if (n % i == 0) {
        return false;
      }
      ++i;
    }
    return true;
  }
  public static boolean isPrime(long n){
    //tip paametra long-64 bitnie chisla
    for (long i=2; i<n; i+=1){

      if (n%i ==0){
        return false;
      }
    }
    return true;
  }
}
