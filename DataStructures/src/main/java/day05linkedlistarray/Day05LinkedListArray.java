package day05linkedlistarray;


public class Day05LinkedListArray {
    public static void main(String[] args) {
     LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("Jerry");
        instance.add("Terry");
        instance.add("Barry");
        instance.add("Larry");
        instance.add("Marry");
        System.out.println(instance.toString());
        String [] array=instance.toArray();
        for(int i=0;i<array.length; i++) {
        System.out.println(array[i]);
    }
    }
    
    
}
