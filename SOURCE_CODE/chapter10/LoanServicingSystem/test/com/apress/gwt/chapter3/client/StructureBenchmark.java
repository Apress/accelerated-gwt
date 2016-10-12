package com.apress.gwt.chapter3.client;

import java.util.ArrayList;
import java.util.HashSet;

import com.google.gwt.benchmarks.client.Benchmark;
import com.google.gwt.benchmarks.client.IntRange;
import com.google.gwt.benchmarks.client.IterationTimeLimit;
import com.google.gwt.benchmarks.client.Operator;
import com.google.gwt.benchmarks.client.RangeField;
import com.google.gwt.benchmarks.client.Setup;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class StructureBenchmark extends Benchmark {

  public HashSet<Integer> hashSet = new HashSet<Integer>();
  public ArrayList<Integer> arrayList = new ArrayList<Integer>();

  final IntRange sizeRange = new IntRange(10000, 15500, Operator.ADD, 200);

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.apress.gwt.chapter3.LoanServicingSystem";
  }

  /**
   * Populates the ArrayList with integers 0 <= x <= size
   *
   * @param size Upper limit of the integers to add in the structure
   */
  public void populateArrayList(Integer size) {
    arrayList.clear();
    for (int i = 0; i <= size.intValue(); i++)
      arrayList.add(i);
  }

  /**
   * Populates the HashSet with integers 0 <= x <= size
   *
   * @param size Upper limit of the integers to add in the structure
   */
  public void populateHashSet(Integer size) {
    hashSet.clear();
    for (int i = 0; i <= size.intValue(); i++)
      hashSet.add(i);
  }

  /**
   * JUnit requires a method that takes no arguments. It is not used for
   * Benchmarking.
   */
  public void testArrayList() {
  }

  @Setup("populateArrayList")
  @IterationTimeLimit(1000)
  public void testArrayList(@RangeField("sizeRange") Integer size) {
    for (int i = 1; i < size.intValue(); i++) {
      arrayList.contains(i);
    }
  }

  public void testHashSet() {
  }

  @Setup("populateHashSet")
  @IterationTimeLimit(1000)
  public void testHashSet(@RangeField("sizeRange") Integer size) {
    for (int i = 1; i < size.intValue(); i++) {
      hashSet.contains(i);
    }
  }
}
