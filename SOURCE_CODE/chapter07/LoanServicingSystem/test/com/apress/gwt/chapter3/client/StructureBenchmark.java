package com.apress.gwt.chapter3.client;

import java.util.ArrayList;
import java.util.HashSet;

import com.google.gwt.junit.client.Benchmark;
import com.google.gwt.junit.client.IntRange;
import com.google.gwt.junit.client.Operator;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class StructureBenchmark extends Benchmark {

  public HashSet hashSet = new HashSet();
  public ArrayList arrayList = new ArrayList();

  final IntRange sizeRange = new IntRange(10000, 15500, Operator.ADD, 200);

  public void setUp(){
  }
  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.apress.gwt.chapter3.LoanServicingSystem";
  }

  /**
   * Populates the ArrayList with integers 0 <= x <= size
   * @param size Upper limit of the integers to add in the structure
   */
  public void populateArrayList(Integer size) {
    for (int i = 0; i <= size.intValue(); i++)
      arrayList.add(new Integer(i));
  }

  /**
   * Populates the HashSet with integers 0 <= x <= size
   * @param size Upper limit of the integers to add in the structure
   */
  public void populateHashSet(Integer size) {
    for (int i = 0; i <= size.intValue(); i++)
      hashSet.add(new Integer(i));
  }

  /**
   * JUnit requires a method that takes no arguments. It is not used for
   * Benchmarking.
   */
  public void testArrayList() {
  }

  /**
   * @gwt.benchmark.param size = sizeRange
   */
  public void testArrayList(Integer size) {
    arrayList.clear();
    populateArrayList(size);
    for (int i = 1; i < size.intValue(); i++) {
      arrayList.contains(new Integer(i));
    }
  }

  public void testHashSet() {
  }

  /**
   * @gwt.benchmark.param size = sizeRange
   */
  public void testHashSet(Integer size) {
    hashSet.clear();
    populateHashSet(size);
    for (int i = 1; i < size.intValue(); i++) {
      hashSet.contains(new Integer(i));
    }
  }
}