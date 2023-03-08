public class program {
    public static void main(String[] args) {
        boolean flag = true;

        while (flag) {
            switch (Menu.show()) {
                case 1:
                    Toy.poolInfo();
                    break;
                case 2:
                    Menu.addToy();
                    break;
                case 3:
                    Menu.getToy();
                    break;
                case 4:
                    flag = false;
                default:
                    System.out.println("Выберите существующий пункт!");
            }
        }
    }
}
