package Main;

import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        final int size = 1000000;
        final int half = size / 2;
        float[] array = new float[size];
        long startTime = 0, endTime = 0;
        float[] fullArray;
        fullArray = fillArray(array);
        countTimeForProgramInOneStream(fullArray,startTime,endTime);
        fullArray = fillArray(array);
        countTimeForProgramInTwoStream(array,startTime,endTime,half);

    }

    static void countTimeForProgramInTwoStream(float[] array, long startTime, long endTime, int size){
        float[] a1 = new float[size];
        float[] a2 = new float[size];
        Thread thread1 = new Thread();


        startTime = System.currentTimeMillis();
        System.arraycopy(array,0,a1,0,size);
        System.arraycopy(array,size,a2,0,size);

        System.arraycopy(a1,0,array,0,size);
        System.arraycopy(a2,0,array,size,size);
        endTime = System.currentTimeMillis();
        System.out.println("Time for do program in 2 stream = "+(endTime-startTime));
    }

    static void countTimeForProgramInOneStream(float[] array, long startTime, long endTime){
        startTime = System.currentTimeMillis();
        doOperationArray(array);
        endTime = System.currentTimeMillis();
        System.out.println("Time for do program in 1 stream = "+(endTime-startTime));
    }

    static float[] fillArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        return array;
    }

    static float[] doOperationArray(float[] inArray){
            for (int i = 0; i <inArray.length ; i++) {
               inArray[i] = (float)(inArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            return inArray;
        }


}
