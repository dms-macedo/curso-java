package introduction.exercises;

public class ex001 {
    public static void main(String[] args) {
        int honra = 0;
        String desfecho = "";
        if (honra < 0) {
            desfecho = "Final: Lobo";
        } else if (honra == 0) {
            desfecho = "Final: Neutro";
        } else {
            desfecho = "Final: Cervo";
        }

        System.out.println(desfecho);
    }
}
