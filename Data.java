public class Data {
    Data(String str) {
        System.out.println(str);
    }

    public static void main(String a[]) {
        Data[] arr = new Data[5];
        arr[0] = new Data("A");
        arr[1] = new Data("B");
        arr[2] = new Data("C");
        arr[3] = new Data("D");
        arr[4] = new Data("E");
    }
}