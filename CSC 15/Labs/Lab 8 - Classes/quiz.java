public class quiz
{
    public static void main (String[] args)
    {
        int[] array = new int[];
        array[0] = 1;
        System.out.println(even(array));
    }



public static boolean even(int[] a) {
    boolean result = false;
    for(int i = 0; i < a.length; i++) {
        if(a[i] % 2 == 0)
            result = true;
    }
    return result;
}
}