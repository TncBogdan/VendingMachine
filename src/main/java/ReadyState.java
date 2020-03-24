public class ReadyState extends State {


    public ReadyState(VendingMachine vendingMachine) {
        super(vendingMachine);
        getVendingMachine();
        displayItem();
        selectItem();
    }

    private void displayItem() {
        int length = getVendingMachine().getItem().size();
        if (length != 0){
            for (int i = 0; i < length; i++) {
                Item item = getVendingMachine().getItem().get(i);
                System.out.println(i+  "\t" + item.getName() +
                        "\t\t\t" + item.getPrice());
            }
        }
        else {
            System.out.println("There is no item left.");
            System.exit(0);
        }
    }

    public void selectItem() {
        if (getVendingMachine().getItem().size() > 0){
            System.out.println("Select product...");
            int product = scanner.nextInt();
            getVendingMachine().setSelectedItem(getVendingMachine().getItem().get(product));
        }
    }

    public void collectCash() {
        System.out.println("Enter your money... ");
        int money = scanner.nextInt();
        getVendingMachine().setCash(getVendingMachine().getCash()+ money);
        if (getVendingMachine().getCash() < getVendingMachine().getSelectedItem().getPrice()) {
            System.out.println("Not enought founds.");
            collectCash();
        }
        else {
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            getVendingMachine().changeState(new DispenseItemState(getVendingMachine()));
        }
    }

    public void dispenceItem() {

    }

    public void dispenceChange() {

    }
}
