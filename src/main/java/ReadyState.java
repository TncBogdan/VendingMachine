import java.util.Scanner;

public class ReadyState {
    Scanner scanner = new Scanner(System.in);
    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        getVendingMachine();
        this.setVendingMachine(vendingMachine);
        displayItem();
        selectItem();
    }

    public ReadyState() {
    }

    private void displayItem() {
        int length = getVendingMachine().getItem().size();
        if (length != 0) {
            for (int i = 0; i < length; i++) {
                Item item = getVendingMachine().getItem().get(i);
                System.out.println(i + "\t" + item.getName() +
                        "\t\t\t" + item.getPrice());
            }
        } else {
            System.out.println("There is no item left.");
            System.exit(0);
        }
    }

    public void selectItem() {
        if (getVendingMachine().getItem().size() > 0) {
            System.out.println("Select product...");
            int product = scanner.nextInt();
            getVendingMachine().setSelectedItem(getVendingMachine().getItem().get(product));
        }
    }

    public void collectCash() {
        System.out.println("Enter your money... ");
        int money = scanner.nextInt();
        getVendingMachine().setCash(getVendingMachine().getCash() + money);
        if (getVendingMachine().getCash() < getVendingMachine().getSelectedItem().getPrice()) {
            System.out.println("Not enought founds.");
            collectCash();
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getVendingMachine().changeState(new ReadyState(getVendingMachine()));
        }
    }

    public void dispenceChange() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int change = getVendingMachine().getCash() - getVendingMachine().getSelectedItem().getPrice();

        System.out.println("Please collect change amount of " + change);
        getVendingMachine().changeState(new ReadyState(getVendingMachine()));
        getVendingMachine().start();
    }

    public void dispenceItem() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getVendingMachine().getItem().remove(getVendingMachine().getSelectedItem());
        System.out.println("Please collect " + getVendingMachine().getSelectedItem().getName());
        getVendingMachine().changeState(new ReadyState(getVendingMachine()));
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
