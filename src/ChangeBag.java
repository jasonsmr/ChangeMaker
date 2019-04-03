public class ChangeBag {
    private long quarters = 0;
    private long dimes = 0;
    private long nickels = 0;
    private long pennies = 0;



    public ChangeBag(long quarters, long dimes, long nickels, long pennies) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }

    @Override
    public String toString() {
        return "ChangeBag{" +
                "quarters=" + quarters +
                ", dimes=" + dimes +
                ", nickels=" + nickels +
                ", pennies=" + pennies +
                '}';
    }

    public long getQuarters() {
        return quarters;
    }

    public void setQuarters(long quarters) {
        this.quarters = quarters;
    }

    public long getDimes() {
        return dimes;
    }

    public void setDimes(long dimes) {
        this.dimes = dimes;
    }

    public long getNickels() {
        return nickels;
    }

    public void setNickels(long nickels) {
        this.nickels = nickels;
    }

    public long getPennies() {
        return pennies;
    }

    public void setPennies(long pennies) {
        this.pennies = pennies;
    }
}