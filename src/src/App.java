import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        User u1 = new User(1, "wlc", "walace@hotmail.com", "walace123");
        u1.setCount(0);

        boolean loginValido = false;
        int maxTentativas = 3;

        while (!loginValido) {
            if (u1.getCount()>= maxTentativas){
                System.out.println("Você excedeu o numero máximo de tentátivas. Deseja redefinir a sua senha? (Sim/Não)");
                String resposta = sc.nextLine();

                if (resposta.equalsIgnoreCase("Sim")){
                    System.out.println("Digite a nova senha: ");
                    String novaSenha = sc.nextLine();
                    u1.setPassword(novaSenha);
                    u1.setCount(0);
                    System.out.println("Senha alterada! Faça login novamente.");
                } else {
                    System.out.println("Acesso encerrado.");
                    break;
                }
            }


            System.out.println("Digite o seu email: ");
            String emailDigitado = sc.nextLine();

            System.out.print("Digite a sua senha: ");
            String senhaDigitada = sc.nextLine();


            if (senhaDigitada.equals(u1.getPassword()) && emailDigitado.equals(u1.getEmail())) {
                System.out.println("Login realizado com sucesso");
                loginValido = true;
            } else {
                u1.setCount(u1.getCount() + 1);
                System.out.println("Email ou senha incorretos! Tentativa " + u1.getCount() + " de " + maxTentativas + "\n");
            }
        }
        sc.close();

    }
}
