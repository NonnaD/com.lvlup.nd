package hashFunctions;

import java.util.LinkedList;

public class DirectChaining {
//    public static void main(String[] args) {
//        hashCodeFunction();
//    }
    String key;
    LinkedList<String>[] values;
    int maxSizeForValues = 5;

    public DirectChaining(int numberOfElements) {
        maxSizeForValues = numberOfElements;
        this.values = new LinkedList[numberOfElements];
    }

    public boolean insert(String value){
        int key = hashCodeFunction(value, maxSizeForValues);
        if (values[key] == null)   values[key] = new LinkedList<String>();
        return values[key].add(value);
    }


    public static int hashCodeFunction(String toBeHashed, int mod){
        char[] arr = toBeHashed.toCharArray();
        int sum, i;
        for (sum = 0,i =0; i < arr.length; i++){
            //sum of chars in "toBeHashed" arr converted to int
            // char(16 bit) is upcasted to int(32) since char < int
            sum = sum + arr[i];
        }

        return sum % mod;
    }

    /**
     * O(n) = 1  we decode our val to get it exact index
     * Actually we do not perform any search because we have index
     * We just need to retrieve the index from value
     */
    public int searchByValue(String val){
        int index = hashCodeFunction(val, maxSizeForValues);
        if (values[index] != null && values[index].contains(val)){
            return index;
        }
        else return -1;
    }

    public boolean deleteByValue(String val){
        int index = searchByValue(val);
        if (index!=-1){
            return values[index].remove(val);
        }
        return false;
    }


    public void printTable(){
        for (int i = 0; i < values.length; i++){
            System.out.println("index " + i + " | values: " + values[i]);
        }
    }
}
