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
       int  d=0;
        while(i<n) {
            System.out.println();
            System.out.println("Enter equation number "+i);
            String eqn = st.nextLine();
           if( eqn_matcher(eqn, req_pattern,i)==-1){d=-1;break;}
            i++;
        }
        if(d==0){
        createMatrix();
        }
    }
    public static String create_pattern(int n){
        String linear_pattern_2 = "[+ - *]{0}^[- +]{0,1}[\\d]{1,19}  [a-z]{1}";
        String add_part = "[+ \\- *]?[\\d]{1,19}[a-z]";
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


    public static int  eqn_matcher(String eqn, String linear_pattern_2,int row){
        Pattern pattern = Pattern.compile(linear_pattern_2);

        Matcher matcher = pattern.matcher(eqn);
        if(matcher.matches()) {
            String[] data = eqn.split("[\\+ \\-]");
            for(int i=0; i<data.length; i++){
                System.out.println(data[i]);
            }
            int i =0,j=0;
            while(i<data.length) {
               String val[] = data[i].split("[a-z]");
               arr[row][j] = Integer.parseInt(val[0]);
                j++;
                i++;
            }
            return 0;
        }
        else{
            System.out.println("No match");
            return -1;
        }
    }
    public static void createMatrix(){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

    }
}

