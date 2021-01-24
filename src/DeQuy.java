public class DeQuy {
    public static void main(String[] args) {

        int n = 864783;
        System.out.println(findNumber(n));

    }

    private static int findNumber(int n) {
        String s = String.valueOf(n);
        String[] sArray = s.split("");
        if (sArray.length == 1) {
            return n;
        }
        int[] array = new int[sArray.length];
        int[] arrayTang = new int[array.length];
        int[] arrayGiam = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(sArray[i]);
            arrayTang[i] = Integer.parseInt(sArray[i]);
            arrayGiam[i] = Integer.parseInt(sArray[i]);
        }
        arrayTang = tang(arrayTang);
        arrayGiam = giam(arrayGiam);

        String sTang = "";
        String sGiam = "";
        for (int i = 0; i < arrayTang.length; i++) {
            sTang += String.valueOf(arrayTang[i]);
            sGiam += String.valueOf(arrayGiam[i]);
        }

        return Integer.parseInt(sTang) < Integer.parseInt(sGiam)?Integer.parseInt(sTang):Integer.parseInt(sGiam);

    }

    static int[] tang(int[] array){
        for (int i = array.length-1; i > 0; i--) {
            if (array[i] < array[i-1]) {
                array[i] = array[i-1];
                return tang(array);
            }
        }
        return array;
    }

    static int[] giam(int[] array) {
        for (int i = array.length-1; i > 0; i--) {
            if (array[i] > array[i-1]) {
                array[i] = 0;
                if(array[i-1]!=0) {
                    array[i-1]++;
                }
                return giam(array);
            }
        }
        return array;
    }
}
