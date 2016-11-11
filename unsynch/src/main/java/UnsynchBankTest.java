/**
 * Created by ScorpionOrange on 2016/11/10.
 * This program shows data corruption when multiple threads access a data structure.
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALENCE = 1000;

    public static void main(String[] args){
        Bank b = new Bank(NACCOUNTS, INITIAL_BALENCE);
        int i;
        for(i = 0; i < NACCOUNTS; i++){
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALENCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
