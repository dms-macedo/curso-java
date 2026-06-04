package academy.devdojo.maratonajava.javacore.Oexceptions.runtime.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {
    public static void main(String[] args) {
        try {
            throw new IndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e){
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e){
            System.out.println("Dentro do IndexOutOfBoundsException");
        } catch (RuntimeException e){
            System.out.println("Dentro do RuntimeException");
        }

        try {
            talvezLanceException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException{
        
    }
}
