
public class LargestOne {
    public static int findTheLargest (int[]arr, int length) {
        int max = -65500;
        for(int i = 0; i < length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
            int[] arr = new int[]{1,2,3,5,3,44};

        System.out.println("The largest Number " + findTheLargest(arr, 6));
    }
}
