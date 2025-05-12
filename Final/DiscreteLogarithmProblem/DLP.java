import java.util.ArrayList;

public class DLP {


    public static void calculateOrders(int p) {
        ArrayList<Integer> order = new ArrayList<Integer>();
        System.out.println("Orders in Z"+ "*"+ p);

        for (int g=1; g<p; g++) {
            int power = g;
            int k=1;

            System.out.print("g = "+ g +": "+ power);

            while (power!=1) {
                power = (power*g)%p;
                k++;
                System.out.print(" " + power);
            }
            order.add(k);
            System.out.println(" (order: "+ k +" mod "+ p +")");
        }
        System.out.println("Full order: "+ order);
        order.clear();
        System.out.println();
    }
}
