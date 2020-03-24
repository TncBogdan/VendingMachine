import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private Item selectedItem;
    private int cash;
    private List<Item> items = new ArrayList<Item>();
    private State state;

    public VendingMachine() {
        fillItems();
        state = new ReadyState(this);
    }

    public void changeState(State state){
        this.state = state;
    }

    public void start(){
        state.collectCash();
        state.dispenceItem();
        state.dispenceChange();
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
