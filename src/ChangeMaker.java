import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class ChangeMaker {
    private double amount;
    private static boolean quartersAvail = true;
    private static boolean dimesAvail = true;
    private static boolean nickelsAvail = true;
    private static boolean penniesAvail = true;
    private long amQuarters = 0;
    private long amDimes = 0;
    private long amNickels = 0;
    private long amPennies = 0;

    /******************************************************************
     *
     *
     *
     *
     ******************************************************************/

    public ChangeMaker() {
        this.amount = 0.0;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public static void setQuartersAvail(boolean quartersAvail) {
        ChangeMaker.quartersAvail = quartersAvail;
    }

    public static boolean getQuartersAvail() {
        return ChangeMaker.quartersAvail;
    }

    public static void setDimesAvail(boolean dimesAvail) {
        ChangeMaker.dimesAvail = dimesAvail;
    }

    public static boolean getDimesAvail() {
        return ChangeMaker.dimesAvail;
    }

    public static void setNickelsAvail(boolean nickelsAvail) {
        ChangeMaker.nickelsAvail = nickelsAvail;
    }

    public static boolean getNickelsAvail() {
        return ChangeMaker.nickelsAvail;
    }

    public static void setPenniesAvail(boolean penniesAvail) {
        ChangeMaker.penniesAvail = penniesAvail;
    }

    public static boolean getPenniesAvail() {
        return ChangeMaker.penniesAvail;
    }
    public ChangeMaker(ChangeMaker other) {
        this.amount = other.amount;
        this.quartersAvail = other.quartersAvail;
        this.dimesAvail = other.dimesAvail;
        this.nickelsAvail = other.nickelsAvail;
        this.penniesAvail = other.penniesAvail;
        this.amQuarters = other.amQuarters;
        this.amDimes = other.amDimes;
        this.amNickels = other.amNickels;
        this.amPennies = other.amPennies;
    }

    public ChangeMaker(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount is too low");
        }

        if (amount >= 1.0E15) {
            throw new IllegalArgumentException("Amount is too high");
        }

        if (((double) Math.round(amount * 100) / 100) != amount) {
            throw new IllegalArgumentException("Not a valid currency1");
        }
        this.amount = amount;
    }

    public boolean equals(Object Change) {
        if (Change instanceof ChangeMaker) {
            ChangeMaker chng = (ChangeMaker) Change;
            if (chng.amount == this.amount) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(ChangeMaker Change) {
        if (Change.amount == this.amount) {
            return true;
        }
        return false;
    }

    public static boolean equals(ChangeMaker other1, ChangeMaker other2) {
        if (other1.amount == other2.amount) {
            return true;
        }
        return false;
    }

    public int compareTo(ChangeMaker other) {
        if (this.amount > other.amount) {
            return 1;
        } else if (this.amount < other.amount) {
            return -1;
        } else
            return 0;
    }

    public static int compareTo(ChangeMaker other1, ChangeMaker other2) {
        if (other1.amount > other2.amount) {
            return 1;
        } else if (other1.amount < other2.amount) {
            return -1;
        } else
            return 0;
    }

    public void loadMachine(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount is too low");
        }

        if (amount >= 1.0E15) {
            throw new IllegalArgumentException("Amount is too high");
        }

        if (((double) Math.round(amount * 100) / 100) != amount) {
            throw new IllegalArgumentException("Not a valid currency1");
        }

        this.amount += amount;
    }

    public static boolean isQuartersAvail() {
        return quartersAvail;
    }

    public static boolean isDimesAvail() {
        return dimesAvail;
    }

    public static boolean isNickelsAvail() {
        return nickelsAvail;
    }

    public static boolean isPenniesAvail() {
        return penniesAvail;
    }

    public ChangeBag takeOut(double amount) {
        System.out.print("raw data: "+amount+"\n");
        long tempAmount = Math.round(amount * 100);
        //String test = ""+((double) (Math.floor(amount * 100) / 100));
        String test = toStringL(amount);
        System.out.print("As string" +test+"\n");
        double transferAmnt = Double.parseDouble(test);
        //double floating = Double.parseDouble("$"+test);
        System.out.print("After Double:" +transferAmnt+"\n");
        //System.out.print(Double.parseDouble(this.toString()));
        //System.out.print("After Trunk: "+((double) Math.floor(amount * 100) / 100));
        //if (floating != Double.parseDouble(this.toString()))


        if (this.amount < amount ){
            throw new IllegalArgumentException("Not enough in bank");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount is too low");
        }

        if (amount >= 1.0E15) {
            //redundent
            throw new IllegalArgumentException("Amount is too high");
        }

        if (transferAmnt != ((double) Math.round(amount * 100) / 100)) {
            throw new IllegalArgumentException("Not a valid currency2");
        }

//        if(0 == 0){
//            System.out.println("this version of amount: " + amount);
//            System.out.println("next version of amount: " + (Math.floor(amount * 100) / 100));
//            }

        long quarters = 0;
        long dimes = 0;
        long nickels = 0;
        long pennies = 0;
        ChangeBag item = new ChangeBag(quarters, dimes, nickels, pennies);
        double subtract = amount;
        amQuarters = item.getQuarters();
        amDimes = item.getDimes();
        amNickels = item.getNickels();
        amPennies = item.getPennies();


        if ((isQuartersAvail())) {
            if((tempAmount %100) != 5 ) {
                amQuarters = tempAmount / 25;
                quarters = amQuarters;
                tempAmount = tempAmount - (quarters * 25);
                amount = amount - (quarters * .25);
                amount = (double) Math.round(amount * 100) / 100;
            }
            else{
                amQuarters = (tempAmount / 25) - 1;
                quarters = amQuarters;
                tempAmount = tempAmount - (quarters * 25);
                amount = amount - (quarters * .25);
                amount = (double) Math.round(amount * 100) / 100;
            }

        }

        System.out.println("Num quarters: " + amQuarters);
        System.out.println("TakeOut left: " + amount);
        if (isDimesAvail()) {
            amDimes = tempAmount / 10;
            dimes = amDimes;
            tempAmount = tempAmount - (dimes * 10);
            amount = amount - (dimes * .1);
            amount = (double) Math.round(amount * 100) / 100;

        }
        System.out.println("Num Dimes: " + amDimes);
        System.out.println("TakeOut left: " + amount);
        if (isNickelsAvail()) {
            amNickels = tempAmount / 5;
            nickels = amNickels;
            tempAmount = tempAmount - (nickels * 5);
            amount = amount - (nickels * .05);
            amount = (double) Math.round(amount * 100) / 100;

        }
        System.out.println("Num Nickles: " + amNickels);
        System.out.println("TakeOut left: " + amount);
        if (isPenniesAvail()) {
            amPennies = tempAmount;
            pennies = amPennies;
            tempAmount = tempAmount - pennies;
            amount = amount - (pennies * .01);

        }
        System.out.println("Num Pennies: " + amPennies);
        System.out.println("TakeOut left: " + amount);
//        if ((amount - (double) Math.floor(amount * 100) / 100) != 0) {
//            amount = (double) Math.round(amount * 100) / 100;
//        }

        if (amount != 0) {
            amQuarters = 0;
            amDimes = 0;
            amNickels = 0;
            amPennies = 0;
            throw new IllegalArgumentException("ATM Err: Re-change");

        }
        else {
            this.amount = this.amount - subtract;
            System.out.println("Amount Left: " + this.amount);
            return item;
        }
    }

    public long getAmQuarters() {
        return amQuarters;
    }

    public long getAmDimes() {
        return amDimes;
    }

    public long getAmNickels() {
        return amNickels;
    }

    public long getAmPennies() {
        return amPennies;
    }

//    public String toString() {
//        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//        String moneyString = formatter.format(getAmount());
//        return moneyString;
//    }

    public String toStringL(Double amount) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setGroupingUsed(false);
        formatter.setMinimumFractionDigits(2);
        String DoubleD = formatter.format(amount);
        return DoubleD;
    }

    public void save(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

        } catch (Exception error) {
            throw new IllegalArgumentException("Save: Illegal name");
        }
        out.println(this.amount);
        out.close();
    }

    public void load(String fileName) {

        try {
            Scanner fileReader = new Scanner(new File(fileName));

            if ((amount <= 0)) {
                throw new IllegalArgumentException("Amount is too low");
            }
            if (amount >= 1.0E15) {
                throw new IllegalArgumentException("Amount is too high");
            }
            if (((double) Math.round(amount * 100) / 100) != amount) {
                throw new IllegalArgumentException("Not a valid currency");
            }

            this.amount = fileReader.nextDouble();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }


}