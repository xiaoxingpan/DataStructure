package day05arraylistownimpl;

public class ArrayListOwnImpl {

    public static void main(String[] args) {
        Day05ArrayListOwn myArray = new Day05ArrayListOwn();
        myArray.add(3);
        myArray.add(5);
        myArray.add(7);
        myArray.add(2);
        myArray.add(4);
        myArray.insertValueAtIndex(9, 0);
        myArray.insertValueAtIndex(8, 5);
        myArray.insertValueAtIndex(7, 1);
        System.out.println(myArray);
        System.out.println(myArray.size() + ", length: " + myArray.length());
//        myArray.deleteByIndex(2);
//        System.out.println(myArray);
//        System.out.println(myArray.size() + ", length: " + myArray.length());
//        System.out.println("[3] = " + myArray.get(3));
//        myArray.deleteByValue(3);
//        System.out.println(myArray);
//        System.out.println(myArray.size() + ", length: " + myArray.length());
//        myArray.add(3);
//        myArray.add(5);
//        myArray.add(7);
//        myArray.add(2);
//        myArray.add(4);
//        System.out.println(myArray);
//        System.out.println(myArray.size() + ", length: " + myArray.length());
//        myArray.insertValueAtIndex(9,3);
//        System.out.println(myArray);
//        System.out.println(myArray.size() + ", length: " + myArray.length());
//        myArray.getSlice(3, 5);

    }

}
