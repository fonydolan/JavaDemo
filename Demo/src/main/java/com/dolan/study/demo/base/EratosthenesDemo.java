package com.dolan.study.demo.base;

import java.util.BitSet;

public class EratosthenesDemo {
  public void main(){
    int n = 2000000;
    long start = System.currentTimeMillis();
    BitSet bs = new BitSet(n+1);
    int count = 0;
    int i;
    for(i=2;i<=n;i++){
      bs.set(i);
    }
    i=2;
    while(i*i<=n){
      if(bs.get(i)){
        count++;
        int k= 2*i;
        while(k<=n){
          bs.clear(k);
          k+=i;
        }
      }
      i++;
    }
    while(i<=n){
      if(bs.get(i))count++;
      i++;
    }
    long end = System.currentTimeMillis();
    System.out.println(count+"primes");
    System.out.println((end-start)+"milliseconds");
    
    
    
    
  }
}
