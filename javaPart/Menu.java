import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static int show() {
        System.out.println("[1] Просмотр");
        System.out.println("[2] Добавить");
        System.out.println("[3] Вытащить");
        System.out.println("[4] Выход");
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка! Введите номер пункта");
            return show();
        }
    }

    public static void addToy() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Название игрушки: ");
        String name = sc.nextLine();
        try {
            System.out.print("Колличество: ");
            int amount = sc.nextInt();
            for(int i = 0; i < amount; i++){
                new Toy(name);
            }
        } catch (Exception e) {
            System.out.print("Введите целое число!\n");
            addToy();
        }
    }


    public static void getToy() {
        Random r = new Random();
        int num = r.nextInt(Toy.amountOfToys());
        Toy.printToy(num);
        Toy.removeToy(num);
    }
}
