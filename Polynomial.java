import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public static void main(String[] args) {
        String pattern = "([+-]?\\s*([\\d-]*)\\s*[A-Za-z]\\s*[\\^]?\\s*([\\d]?)\\s*[+-]?)";
        Pattern r = Pattern.compile(pattern);
        Scanner sc = new Scanner(System.in);
        String eqn = sc.nextLine();
        Matcher m = r.matcher(eqn);
        while(m.find()){
            //System.out.println(m.group(1));
            System.out.println(m.group(2));
            if(m.group(3).isEmpty()){

                System.out.println(1);
            }
            else {
                System.out.println(m.group(3));
            }
        }
    }

}