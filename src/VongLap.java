public class VongLap {
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
        int[] tang = new int[array.length];
        int[] giam = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(sArray[i]);
            tang[i] = Integer.parseInt(sArray[i]);
            giam[i] = Integer.parseInt(sArray[i]);
        }

        boolean check1 = false;
        boolean check2 =false;
        while (!check1) {
            boolean flag = true;
            for (int i = tang.length-1; i > 0; i--) {
                if (tang[i] < tang[i-1]) {
                    tang[i] = tang[i-1];
                    flag = false;
                    break;
                }
            }
            check1 = flag?true:false;
        }
        while (!check2) {
            boolean flag = true;
            for (int i = giam.length-1; i > 0; i--) {
                if (giam[i] > giam[i-1]) {
                    giam[i] = 0;
                    if (giam[i-1] != 0) {
                        giam[i-1]++;
                    }
                    flag = false;
                    break;
                }
            }
            check2 = flag?true:false;
        }
        String sTang = "";
        String sGiam = "";
        for (int i = 0; i < tang.length; i++) {
            sTang += String.valueOf(tang[i]);
            sGiam += String.valueOf(giam[i]);
        }

        return Integer.parseInt(sTang) < Integer.parseInt(sGiam)?Integer.parseInt(sTang):Integer.parseInt(sGiam);
    }
}
