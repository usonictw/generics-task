package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class MyListTest {


    @Test
    public void testAdd() {

        //GIVEN
        MyList<Number> myList = new MyList<>();
        int expected = 3;


        //WHEN
        myList.add(1);
        myList.add(2);
        myList.add(3);

        //THEN
        Assertions.assertEquals(expected, myList.size());
        Assertions.assertEquals(1, myList.get(0));
        Assertions.assertEquals(2, myList.get(1));
        Assertions.assertEquals(3, myList.get(2));
    }

    @Test
    public void testAddWithResize() {

        //GIVEN
        MyList<Number> myList = new MyList<>();
        int expected = 95;

        //WHEN
        for (int i = 0; i < 95; i++) {
            myList.add(i);
        }
        //THEN
        Assertions.assertEquals(expected, myList.size());
    }

    @Test
    public void testGet() {
        //GIVEN
        MyList<Number> myList = new MyList();
        int index = 0;
        int index2 = 1;
        Integer execute = 2;

        //WHEN
        myList.add(execute);

        //THEN
        Assertions.assertEquals(execute, myList.get(index));
        Assertions.assertNull(myList.get(index2));
    }

    @Test
    public void testRemove() {
        //GIVEN
        MyList<Number> myList = new MyList();
        int index = 4;
        int sizeExecute = 3;
        int index2 = 1;
        int sizeExecute2 = 3;

        //WHEN
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        myList.remove(index);
        myList.remove(index2);


        //THEN
        Assertions.assertEquals(sizeExecute, myList.size());
        Assertions.assertEquals(sizeExecute2, myList.size());
        Assertions.assertNotNull(myList.get(index2));
        Assertions.assertNull(myList.get(index));
    }


    @Test
    public void testToString() {
        //GIVEN
        MyList<Number> myList = new MyList();
        String s = "[0, 1, 2, 3, 4]";
        String s1 = "[0, 1, 2, 3, 4, 5]";

        //WHEN
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        //THEN
        Assertions.assertEquals(s, myList.toString());
        Assertions.assertNotEquals(s1, myList.toString());
    }

    @Test
    public void testHashCode(){
        //GIVEN
        MyList<Number> myList = new MyList();
        MyList<Number> myList1 = new MyList();

        //WHEN
        for (int i = 0; i < 5; i++) {
            myList.add(i);
            myList1.add(i);
        }

        //THEN
        Assertions.assertEquals(myList.hashCode(), myList1.hashCode());
        myList1.remove(4);
        myList1.add(5);
        Assertions.assertNotEquals(myList1, myList);

    }

    @Test
    public void testEqualsNull(){

        //GIVEN
        MyList<Number> myList = new MyList<>();
        List<Number> list = new ArrayList<>();

        boolean checkExecute = false;

        //WHEN
        Assertions.assertEquals(checkExecute, myList.equals(null));
        Assertions.assertEquals(checkExecute, myList.equals(list));
    }

    @Test
    public void testEquals(){
        //GIVEN
        MyList<Number> myList = new MyList();
        MyList<Number> myList1 = new MyList();
        boolean execute = true;

        //WHEN
        for (int i = 0; i < 5; i++) {
            myList.add(i);
            myList1.add(i);
        }

        //THEN
        Assertions.assertEquals(execute, myList.equals(myList1));
        myList1.remove(4);
        myList1.add(5);
        Assertions.assertNotEquals(execute, myList.equals(myList1));
    }

    @Test
    public void testMap(){

        //GIVEN
        MyList<Integer> myListInt = new MyList<>();
        for (int i = 100; i < 500; i += 100 ){
            myListInt.add(i);
        }
        int executeSize = 4;
        Double dExecute = 100.0;
        Float fExecute = 200f;
        Long lExecute = 400L;

        //WHEN
        MyList<Double> doubleMyList = myListInt.map(Integer::doubleValue);
        MyList<Float> floatMyList = myListInt.map(Integer::floatValue);
        MyList<Long> longMyList = myListInt.map(Integer::longValue);
        MyList<Integer> integerMyList = doubleMyList.map(Double::intValue);


        //THEN
        Assertions.assertEquals(executeSize, doubleMyList.size());
        Assertions.assertEquals(executeSize, floatMyList.size());
        Assertions.assertEquals(executeSize, longMyList.size());
        Assertions.assertEquals(executeSize, integerMyList.size());

        Assertions.assertEquals(dExecute, doubleMyList.get(0));
        Assertions.assertEquals(fExecute, floatMyList.get(1));
        Assertions.assertEquals(lExecute, longMyList.get(3));
        Assertions.assertEquals(100, integerMyList.get(0));

    }




}
