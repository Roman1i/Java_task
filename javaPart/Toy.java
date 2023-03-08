import java.util.ArrayList;

public class Toy {

    private static ArrayList<Toy> pool = new ArrayList<>();
    private static int ids = 0;

    private int id;
    private String name;
    private int amount;
    private double rate;


    // Перегрузка 
    public Toy(String name, int amount) {
        if (isInPool(name)){
            for (Toy toy : pool) {
                if (toy.name.equals(name)){
                    toy.amount += amount;
                }
            }
        } else {
            this.id = ids++;
            this.name = name;
            this.amount = amount;
            pool.add(this);  
        }
        
        // Перерасчет процентов при добавлении новых элементов
        int total = 0;
        for (Toy toy : pool) {
            total += toy.amount;
        }
        for (Toy toy : pool) {
            toy.rate = 100.0 / total * toy.amount;
        }
    }

    private static boolean isInPool(String name) {
        for (Toy toy : pool) {
            if (toy.name.equals(name)) return true;
        }
        return false;
    }


    // Статистика
    public static void poolInfo() {
        for (Toy toy : pool) {
            System.out.print(toy.id + " ");
            System.out.print(toy.name + " ");
            System.out.print(toy.amount + " ");
            System.out.println(toy.rate + "%");
        }
    }
}
