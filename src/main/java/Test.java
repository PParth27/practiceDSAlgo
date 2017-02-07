import java.util.*;

/**
 * Created by pparth on 5/12/16.
 */
class Base{
    int value = 0;
    Base(){
        addValue();
    }
    void addValue(){
        value += 10;
    }
    int getValue(){
        return value;
    }
}
class Derived extends Base{
    Derived(){
        addValue();
    }
    void addValue(){
        value +=  30;
    }
}
public class Test {
    public static void main(String[] args){
        Derived b= new Derived();
        System.out.println(b.getValue());
    }
}
