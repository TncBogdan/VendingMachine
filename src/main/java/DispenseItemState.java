import java.sql.SQLOutput;

public class DispenseItemState extends State {
    public DispenseItemState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    public void selectItem() {

    }

    public void collectCash() {

    }

    public void dispenceItem() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        getVendingMachine().getItem().remove(getVendingMachine().getSelectedItem());
        System.out.println("Please collect " + getVendingMachine().getSelectedItem().getName());
        getVendingMachine().changeState(new DispenseChangeState(getVendingMachine()));
    }

    public void dispenceChange() {

    }
}
