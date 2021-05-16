public abstract class Vehicle {
    private int id;
    private int entryHour;
    private int exitHour;

    Vehicle(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getEntryHour() {
        return this.entryHour;
    }

    public void setEntryHour(int entryHour) {
        this.entryHour = entryHour;
    }

    public int getExitHour() {
        return this.exitHour;
    }

    public void setExitHour(int exitHour) {
        this.exitHour = exitHour;
    }

    protected abstract int getEntrancePrice();

    protected abstract int getHourPrice();

    protected int getCost() {
        return this.getEntrancePrice() + this.getHourPrice() * Math.abs(this.exitHour - this.entryHour);
    }
}
