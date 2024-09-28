import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//  String linear_pattern_1= "[+ - *]{0}\\d[a-z][+ \\- *]?\\d[a-z][+ \\-*]?\\d[a-z][+ - *]{0}";
//System.out.println(linear_pattern_1);



public class Pattern_Matcher {

    public static void main(String[] args) {
        int n;

        System.out.println("How many unknowns do you want to find out??");
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        String req_pattern = create_pattern(n);
        String eqn = "7x+6y-5z+8t";
        System.out.println(req_pattern);
        System.out.println("Lets see if we can match the pattern using our logic");
        eqn_matcher(eqn,req_pattern);
    }
    public static String create_pattern(int n){
        String linear_pattern_2 = "[+ - *]{0}\\d[a-z]";
        String add_part = "[+ \\- *]?\\d[a-z]";
        String last_part = "[+ - *]{0}";
        int i=1;
        while(i<n){
            linear_pattern_2+=add_part;

            if(i+1==n){
                linear_pattern_2+=last_part;
            }
            i++;
        }
        return linear_pattern_2;
    }


    public static void eqn_matcher(String eqn, String linear_pattern_2){
        Pattern pattern = Pattern.compile(linear_pattern_2);

        Matcher matcher = pattern.matcher(eqn);
        if(matcher.matches()) {
            String[] data = eqn.split("[\\+ \\-]");
            int i =0;
            while(i<data.length) {
                System.out.println(data[i]);
                i++;
            }
        }
        else{
            System.out.println("No match");
        }
    }
}

