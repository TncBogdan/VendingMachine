public class DispenseChangeState extends State {
    public DispenseChangeState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    public void selectItem() {

    }

    public void collectCash() {

    }

    public void dispenceItem() {

    }

    public void dispenceChange() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int change = getVendingMachine().getCash()-getVendingMachine().getSelectedItem().getPrice();

        System.out.println("Please collect change amount of "+ change);
        getVendingMachine().changeState(new ReadyState(getVendingMachine()));
        getVendingMachine().start();
    }
}
