import java.util.Scanner;

public abstract class State {

    Scanner scanner = new Scanner(System.in);
    private VendingMachine vendingMachine;

    public State(VendingMachine vendingMachine) {
        this.setVendingMachine(vendingMachine);
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void selectItem();

    public abstract void collectCash();

    public abstract void dispenceItem();

    public abstract void dispenceChange();
}
