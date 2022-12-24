import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String[] strArray = new String[10];
        int[] intArray = new int [10];

        ArrayList<String> strArraylist = new ArrayList<String>();
        strArraylist.add("Tim");

       // ArrayList<int> intArrayList = new ArrayList<int>();  ==> this does not work because ArrayList only accepts
        //a class as a parameter, not primitive types

        ArrayList<IntClass> intClassArraylist = new ArrayList<IntClass>(); //we can get around this primitive type issue
        //by creating a class below with a single int field. This basically serves as a wrapper and kinda castes the int
        // to a class but this is a bit messy...so we use auto-boxing
        intClassArraylist.add(new IntClass(9000));

        //autoboxing is just the conversion of a primitive type into the java inbuilt class equivalent
        //unboxing is the reverse

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i = 0; i<=10; i++){
            integerArrayList.add(Integer.valueOf(i)); //.valueOf is a method of the inbuilt Integer class which converts
            //the value of a primitive type (in this case, 'i') into the same Integer value. Autoboxing.
        }

        for (int i = 0; i<=10; i++){
            System.out.println(i + " --> " + integerArrayList.get(i).intValue()); //.intValue unboxes got Integer value
            // of 'i' back into a primitive type. In this case, its a contrived example as we can remove the .intValue
            // and obtain the same print value as we are not actually doing anything further with the value
        }

        Integer myIntValue = 56; // ordinarily with a class, we have to specify like Integer myIntValue = new Integer (56)
        // to create a new object, however, java does the work for us. Java also recognizes that we have input an int
        // for the variable of Integer type. How its read at compile time is actually like this
        // Integer myIntValue = Integer.valueOf(56);
        int myInt = myIntValue; // java also automatically unboxes. Compile time reads as...
        // int myInt = myIntValue.intValue


        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double j = 0.0; j <= 10.0; j+= 0.5){
            myDoubleValues.add(j); //again autoboxing of double primitive type but java does the work at compile time
        }
        for(int i = 0; i<myDoubleValues.size();i++){
            double value = myDoubleValues.get(i); //again unboxing into primitive type but java does work at compile time
            System.out.println(i + " --> " + value);
        }

    }


}

class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}