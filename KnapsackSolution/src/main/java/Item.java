public class Item implements Comparable<Item>{

    int number;
    int w;
    int v;

    public Item(int number, int w, int v) {
        this.number = number;
        this.w = w;
        this.v = v;
    }

    public int getNumber() {
        return number;
    }

    public int getW() {
        return w;
    }

    public int getV() {
        return v;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public int compareTo(Item o) {
        return w-o.w;
    }

    @Override
    public String toString() {
        return "\n------------------ \nNumber : " + this.getNumber() + " \nWeight: " + this.getW() + " \nValue : " + this.getV();
    }

}
