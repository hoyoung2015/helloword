public class Main {

    public static void main(String[] args) {
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i==1 && j==2){
                    break ok;
                }
            }
            System.out.println(i);
        }
    }
}
