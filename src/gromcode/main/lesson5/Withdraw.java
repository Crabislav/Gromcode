package gromcode.main.lesson5;

public class Withdraw {
    public static void main(String[] args) {
        String[] clients = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(withdraw(clients, balances, "Ann", 300));
        System.out.println(withdraw(clients, balances, "Ann", 600));
    }

    public static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client)
                break;
            clientIndex++;
        }
        return clientIndex;
    }

    public static int withdraw(String[] clients, int[] balances, String client, int amount) {
        int clientIndex = findClientIndexByName(clients, client);
        if (clientIndex <= (clients.length - 1)) {
            //int clientIndex = findClientIndexByName(clients, client);
            if (balances[clientIndex] < amount) {
                return -1;
            } else {
                return (balances[clientIndex]) -= amount;
            }
        } else {
            System.out.println("\nClient is absent");
            return -1;
        }
    }
}
