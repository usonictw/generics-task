package org.example;

public class Main {

    public static void main(String[] args) {

        MyList<Integer> myList = new MyList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        MyList<Integer> myList1 = new MyList();

        myList1.add(1);
        myList1.add(2);
        myList1.add(9);
        myList1.add(5);

        System.out.println(myList.equals(myList1));
        System.out.println(myList.hashCode());
        System.out.println(myList1.hashCode());
        MyList<Double> myList2 = myList1.map(Integer::doubleValue);





    }
}
