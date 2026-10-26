package Classes;


import java.util.Scanner;

public class Input {
    private Scanner teclado = new Scanner(System.in);

    public String st(String mensagem) {

        while (true) {
            System.out.println(mensagem);
            String userInput = teclado.nextLine();
            if (userInput != null && !userInput.isBlank()) {
                return userInput;
            } else {
                System.out.println("\nEntrada Inválida: Caractéres não encontrados.");
            }

        }

    }
    public int in(String mensagem){
        while (true) {
            System.out.println(mensagem);
            String userInput = teclado.nextLine();
            if (userInput != null && !userInput.isBlank()) {
                try {
                    
                    int userInputConverted = Integer.parseInt(userInput);

                    return userInputConverted;
                    
                } catch (NumberFormatException e) {
                    System.out.println("\nEntrada Inválida: Digite somente números.");
                }
            } else {
                System.out.println("\nEntrada Inválida: Caractéres não encontrados.");
            }

        }

    }

    public Double db(String mensagem){
         while (true) {
            System.out.println(mensagem);
            String userInput = teclado.nextLine();
            if (userInput != null && !userInput.isBlank()) {
                try {
                    
                    double userInputConverted = Double.parseDouble(userInput);

                    return userInputConverted;
                    
                } catch (NumberFormatException e) {
                    System.out.println("\nEntrada Inválida: Digite somente números.");
                }
            } else {
                System.out.println("\nEntrada Inválida: Caractéres não encontrados.");
            }

        }

    }

    public char ch (String mensagem){
         while (true) {
            System.out.println(mensagem);
            String userInput = teclado.nextLine();
            if (userInput != null && !userInput.isBlank()) {
                return userInput.charAt(0);
            } else {
                System.out.println("\nEntrada Inválida: Caractér não encontrado.");
            }

        }

    }
}
