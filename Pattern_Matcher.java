import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern_Matcher {
    public static void main(String[] args) {
        String fp = "";
        String linear_pattern = "[+ - *]{0}\\d[a-z][+ - *]?\\d[a-z][+ \\-*]?\\d[a-z][+ - *]{0}";
        Pattern pattern = Pattern.compile(linear_pattern);
        String eqn = "7x+6y-5z";
        String plus= eqn+"musab";
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
