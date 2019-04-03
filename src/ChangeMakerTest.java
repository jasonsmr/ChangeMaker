import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/*

   Here is a sample test class that contains several test cases. You are required to:

        1. After running your test cases, 100 percent coverage of ChangeMaker.java
        2. Have at least two @Test methods for each method in ChangeMaker.java class
        3. Test every Method in ChangeMaker (requirement 1 should cover this requirement as well)
        4. Make sure you have tested possible thing to ensure complete and correct functionality of
            ChangeMaker.
        5. Suggestion: Trade test files with your classmate.
 */
public class ChangeMakerTest {

    @Before
    public void initial() {
        ChangeMaker.setQuartersAvail(true);
        ChangeMaker.setDimesAvail(true);
        ChangeMaker.setNickelsAvail(true);
        ChangeMaker.setPenniesAvail(true);
    }
//
    @Test
    public void testConstructor1() {
        ChangeMaker s1 = new ChangeMaker(2.34);
        assertEquals(2.34, s1.getAmount(),0);

        ChangeMaker s2 = new ChangeMaker(34);
        assertEquals(34, s2.getAmount(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2() {
        new ChangeMaker(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3() {
        new ChangeMaker(10.123);
    }

    @Test
    public void testEquals() {
        ChangeMaker s1 = new ChangeMaker(2);
        ChangeMaker s2 = new ChangeMaker(2);
        assertEquals(s1,s2);
    }

    @Test
    public void takeout0() {
        ChangeMaker s1 = new ChangeMaker(.44);
        s1.takeOut(.44);
        assertEquals(0,s1.getAmount(),0);

        s1 = new ChangeMaker(2.00);
        s1.takeOut(.44);
        assertEquals(1.56,s1.getAmount(),0);

        s1 = new ChangeMaker(10);
        s1.takeOut(.50);
        assertEquals(9.5,s1.getAmount(),0);

        s1 = new ChangeMaker(.44E15);
        s1.takeOut(.43E15);
        assertEquals(.01E15,s1.getAmount(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void takeout1() {
        ChangeMaker s1 = new ChangeMaker(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void takeout2() {
        ChangeMaker s1 = new ChangeMaker(1.05E15);
    }
    @Test(expected = IllegalArgumentException.class)
    public void takeout3() {
        ChangeMaker s1 = new ChangeMaker(100);
        s1.takeOut(.443);
    }

    @Test(expected = IllegalArgumentException.class)
    public void takeout4() {
        ChangeMaker s1 = new ChangeMaker(100);
        s1.takeOut(101.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void takeout5() {
        ChangeMaker s1 = new ChangeMaker(1);
        s1.takeOut(.0);
    }
    @Test
    public void takeout6() {
        ChangeMaker s1 = new ChangeMaker(1.05);
        s1.setPenniesAvail(false);
        s1.setNickelsAvail(false);
        s1.takeOut(1.05);
    }
//    @Test(expected = IllegalArgumentException.class)
//    public void takeout7() {
//        ChangeMaker s1 = new ChangeMaker(1);
//        s1.takeOut(0.999999999999999999);
//    }
    @Test(expected = IllegalArgumentException.class)
    public void takeout8() {
        ChangeMaker s1 = new ChangeMaker(0.9999999999999999);
    }
    @Test(expected = IllegalArgumentException.class)
    public void takeout9() {
        ChangeMaker s1 = new ChangeMaker(1.05E15);
    }
    @Test(expected = IllegalArgumentException.class)
    public void takeout10() {
        ChangeMaker s1 = new ChangeMaker(1.0E15);

    }
    @Test(expected = IllegalArgumentException.class)
    public void takeout11() {
        ChangeMaker s1 = new ChangeMaker(100);
        s1.setQuartersAvail(false);
        s1.setDimesAvail(false);
        s1.setNickelsAvail(false);
        s1.setPenniesAvail(false);
        s1.takeOut(100);
    }

    @Test
    public void takeout12 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        ChangeMaker.setQuartersAvail(false);
        ChangeMaker.setNickelsAvail(false);
        s1.takeOut(.25);
    }
    @Test(expected = IllegalArgumentException.class)
    public void takeout13() {
        ChangeMaker s1 = new ChangeMaker(.99E15);
        s1.takeOut(1.05E15);
    }
    @Test
    public void equals01() {
        ChangeMaker s1 = new ChangeMaker(10);
        ChangeMaker s2 = new ChangeMaker(10);
        assertTrue(s1.equals(s1, s2));
    }
    @Test
    public void equals02() {
        ChangeMaker s1 = new ChangeMaker(10);
        ChangeMaker s2 = new ChangeMaker(11);
        assertFalse(s1.equals(s1, s2));
    }
    @Test
    public void equals03() {
        ChangeMaker s1 = new ChangeMaker(11);
        ChangeMaker s2 = new ChangeMaker(11);
        assertTrue(s1.equals(s2));
    }
    @Test
    public void equals04() {
        ChangeMaker s1 = new ChangeMaker(11);
        ChangeMaker s2 = new ChangeMaker(12);
        assertFalse(s1.equals(s2));
    }
    @Test
    public void testCompareTo01() {
        ChangeMaker s1 = new ChangeMaker(2);
        ChangeMaker s2 = new ChangeMaker(2);
        ChangeMaker s3 = new ChangeMaker(1);

        assertTrue(s1.compareTo(s2) == 0);
        assertTrue(s1.compareTo(s3) > 0);
        assertTrue(s3.compareTo(s1) < 0);
    }
    @Test
    public void testCompareTo02() {
        ChangeMaker s1 = new ChangeMaker(3);
        ChangeMaker s2 = new ChangeMaker(2);
        ChangeMaker s3 = new ChangeMaker(1);

        assertFalse(s1.compareTo(s2) == 0);
        assertFalse(s1.compareTo(s3) < 0);
        assertFalse(s3.compareTo(s1) > 0);
    }
    @Test
    public void testCompareTo03() {
        ChangeMaker s1 = new ChangeMaker(3);
        ChangeMaker s2 = new ChangeMaker(2);
        ChangeMaker s3 = new ChangeMaker(1);

        assertTrue(s1.compareTo(s2, s2) == 0);
        assertTrue(s1.compareTo(s3 ,s2) < 0);
        s3.setAmount(4);
        assertTrue(s3.compareTo(s3,s2) > 0);
    }
    @Test
    public void testCompareTo04() {
        ChangeMaker s1 = new ChangeMaker(3);
        ChangeMaker s2 = new ChangeMaker(2);
        ChangeMaker s3 = new ChangeMaker(1);

        assertFalse(s1.compareTo(s2,s3) == 0);
        assertFalse(s1.compareTo(s2,s3) < 0);
        s3.setAmount(4);
        assertFalse(s3.compareTo(s1,s3) > 0);
    }


    @Test
    public void testLoadMachine1 () {
        ChangeMaker s1 = new ChangeMaker();
        s1.loadMachine(123.12);
        assertTrue(s1.getAmount() == 123.12);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLoadMachine2 () {
        ChangeMaker s1 = new ChangeMaker();
        s1.loadMachine(123.123);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLoadMachine3 () {
        ChangeMaker s1 = new ChangeMaker();
        s1.loadMachine(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLoadMachine4 () {
        ChangeMaker s1 = new ChangeMaker();
        s1.loadMachine(1.05E15);
    }
    @Test
    public void testLoadMachine5 () {
        ChangeMaker s1 = new ChangeMaker();
        s1.loadMachine(0.99E15);
        System.out.print(s1.getAmount());
        assertTrue(s1.getAmount() == 9.9E14);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLoadMachine6 () {
        ChangeMaker s1 = new ChangeMaker();
        s1.loadMachine(-1);
    }

    @Test
    public void LoadTest0 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(100);
        s1.load("file.txt");
        assertEquals(4.4, s1.getAmount(), 0);
    }
    @Test
    public void LoadTest1 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(.99E15);
        s1.load("file.txt");
        assertEquals(4.4, s1.getAmount(), 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest2 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(1.0E15);
        s1.load("file.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest3 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(1);
        s1.load("file<:>?|/.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest4 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(1);
        s1.load("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest5 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(1);
        s1.load("not_a_file_in_directory_delete_me");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest6 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(1.05E15);
        s1.load("file.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest7 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(-1);
        s1.load("file.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest8 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file.txt");
        s1.setAmount(0);
        s1.load("file.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest9 () {
        ChangeMaker s1 = new ChangeMaker(4.44);
        s1.setAmount(4.444);
        s1.save("file.txt");
        s1.load("file.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest10 () {
        ChangeMaker s1 = new ChangeMaker(4.444);
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadTest11 () {
        ChangeMaker s1 = new ChangeMaker(100);
        s1.setAmount(-1);
        s1.save("file.txt");
        s1.load("file.txt");
    }
    @Test
    public void SaveTest1 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file");
    }
    @Test(expected = IllegalArgumentException.class)
    public void SaveTest2 () {
        ChangeMaker s1 = new ChangeMaker(4.4);
        s1.save("file<:>?|/.txt");
    }

    @Test
    public void ChangeMakerTest01(){
        ChangeMaker other = new ChangeMaker();
        other.setAmount(0.9E15);
        other.setQuartersAvail(true);
        other.setDimesAvail(true);
        other.setNickelsAvail(true);
        other.setPenniesAvail(true);
        ChangeMaker change = new ChangeMaker(other);
        assertEquals(change.getQuartersAvail(), other.getQuartersAvail());
        assertEquals(change.getDimesAvail(), other.getDimesAvail());
        assertEquals(change.getNickelsAvail(), other.getNickelsAvail());
        assertEquals(change.getPenniesAvail(), other.getPenniesAvail());
        assertTrue(change.getAmount() == other.getAmount());
    }
    @Test
    public void TestQuarters01(){
        ChangeMaker change = new ChangeMaker();
        change.setQuartersAvail(true);
        assertEquals(true, change.getQuartersAvail());
    }
    @Test
    public void TestQuarters02(){
        ChangeMaker change = new ChangeMaker();
        change.setQuartersAvail(false);
        assertEquals(false, change.getQuartersAvail());
    }
    @Test
    public void TestDimes01(){
        ChangeMaker change = new ChangeMaker();
        change.setDimesAvail(true);
        assertEquals(true, change.getDimesAvail());
    }
    @Test
    public void TestDimes02() {
        ChangeMaker change = new ChangeMaker();
        change.setDimesAvail(false);
        assertEquals(false, change.getDimesAvail());
    }
    @Test
    public void TestNickels01() {
        ChangeMaker change = new ChangeMaker();
        change.setDimesAvail(true);
        assertEquals(true, change.getNickelsAvail());
    }
    @Test
    public void TestNickels02(){
        ChangeMaker change = new ChangeMaker();
        change.setNickelsAvail(false);
        assertEquals(false, change.getNickelsAvail());
    }
    @Test
    public void TestPennies01(){
        ChangeMaker change = new ChangeMaker();
        change.setPenniesAvail(false);
        assertEquals(false, change.getPenniesAvail());
    }
    @Test
    public void TestPennies02(){
        ChangeMaker change = new ChangeMaker();
        change.setPenniesAvail(false);
        assertEquals(false, change.getPenniesAvail());
    }
    @Test
    public void Test_getAm(){
        ChangeMaker change = new ChangeMaker();
        change.setAmount(100.00);
        change.takeOut(1.16);
        assertEquals(4, change.getAmQuarters());
        assertEquals(1, change.getAmDimes());
        assertEquals(1, change.getAmNickels());
        assertEquals(1, change.getAmPennies());
    }

}
