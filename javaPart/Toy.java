import java.lang.reflect.Method;
import java.util.ArrayList;

public class Toy {

    private static ArrayList<Toy> pool = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();
    private static int ids = 0;

    private int id;
    private String name;
    private int amount;
    private double rate;


    // Перегрузка 
    public Toy(String name) {
        this.id = ids++;
        this.name = name;
        pool.add(this);
        if (!isInPool(name))
            names.add(name);
        
        refresher();
    }


    //Вывод игрушки по id
    public static void printToy(int id) {
        Toy t = pool.get(id);
        System.out.println("\tВаш выигрыш:");
        System.out.println(t.id + " " + t.name + " " + t.rate + " %");
    }


    // Перерасчет процентов
    private static void refresher() {
        for (Toy toy : pool) {
            toy.rate = 100.0 / pool.size();
        }
    }


    //Удаление игрушки по id
    public static void removeToy(int id) {
        pool.remove(id);
        refresher();
    }


    //Колличество игрушек
    public static int amountOfToys() {
        return pool.size();
    }


    private static boolean isInPool(String name) {
        for (String toyName : names) {
            if (toyName.equals(name)) return true;
        }
        return false;
    }


    // Статистика
    public static void poolInfo() {
        for (String toyName : names) {
            System.out.print(toyName + " ");
            double percent = 0;
            int amount = 0;
            for (Toy toy2 : pool) {
                if(toyName.equals(toy2.name)) {
                    percent += toy2.rate;
                    amount++;
                }
            }
            System.out.print(amount + " ");
            System.out.println(percent + " %");
        }
    }
}
