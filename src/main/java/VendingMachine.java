import java.util.ArrayList;
import java.util.List;

public class VendingMachine extends ReadyState{

    private VendingMachine vendingMachine;
    private Item selectedItem;
    private int cash;
    private List<Item> items = new ArrayList<Item>();
    private ReadyState readyState;

    public VendingMachine() {
        fillItems();
        readyState = new ReadyState(this);
    }

    public VendingMachine(VendingMachine vendingMachine) {

        this.setVendingMachine(this.vendingMachine);
    }

    public void changeState(ReadyState readyState){
        this.readyState = readyState;
    }

    public void start(){
        readyState.collectCash();
        readyState.dispenceItem();
        readyState.dispenceChange();
    }

    public void fillItems(){
        items.add(new Item(1,"Coca Cola", 6));
        items.add(new Item(2,"Fanta", 4));
        items.add(new Item(3,"Mars", 3));
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public List<Item> getItem() {
        return items;
    }

    public void setItem(List<Item> item) {
        this.items = item;
    }

    public ReadyState getReadyState() {
        return readyState;
    }

    public void setReadyState(ReadyState readyState) {
        this.readyState = readyState;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
