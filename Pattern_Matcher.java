import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//  String linear_pattern_1= "[+ - *]{0}\\d[a-z][+ \\- *]?\\d[a-z][+ \\-*]?\\d[a-z][+ - *]{0}";
//System.out.println(linear_pattern_1);



public class Pattern_Matcher {
    public static int n;
    static int[][] arr;
    public static void main(String[] args) {


        System.out.println("How many unknowns do you want to find out??");
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        String req_pattern = create_pattern(n);
        Scanner st = new Scanner(System.in);
        int i=0;
        System.out.println("Lets see if we can match the pattern using our logic");
        while(i<n) {
            System.out.println();
            System.out.println("Enter equation number "+i);
            String eqn = st.nextLine();

            eqn_matcher(eqn, req_pattern,i);
            i++;
        }
        createMatrix();
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


    public static void eqn_matcher(String eqn, String linear_pattern_2,int row){
        Pattern pattern = Pattern.compile(linear_pattern_2);

        Matcher matcher = pattern.matcher(eqn);
        if(matcher.matches()) {
            String[] data = eqn.split("[\\+ \\-]");
            int i =0,j=0;
            while(i<data.length) {
               String val[] = data[i].split("");
               arr[row][j] = Integer.parseInt(val[0]);
                j++;
                i++;
            }
        }
        else{
            System.out.println("No match");
        }


    }
    public static void createMatrix(){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.println(arr[i][j]);
                }
            }

    }
}

