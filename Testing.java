import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testing {
    static int n;
    static int arr[][];
    public static  void main(String[] args) {
        int i=0;
        Scanner string_input = new Scanner(System.in);
        Scanner number_input = new Scanner(System.in);
        System.out.println("How many Unknowns do you want to keep ??");
        System.out.print("=> ");
        n = number_input.nextInt();
        arr = new int[n][n+1];
        boolean validarray=false;
        while (i<n){
            System.out.println("Enter the Equation no "+(i+1));
            String eqn = string_input.nextLine();
            if(Pattern_Matcher(eqn)==1){
                Coefficient_Extractor(eqn,i);
                validarray=true;
            }
            else{
                validarray=false;
                break;
            }
            i++;
        }
        if(validarray){
            printarray();
        }
    }
    public static int Pattern_Matcher(String eqn){
        Pattern pattern = Pattern.compile("^([-+]{0,1}[\\d-]+(?:\\.\\d+)?)[a-zA-Z]{1,10}(?:\\s*([-+]?\\d+(?:\\.\\d+)?)[a-zA-Z]{1,10})*\\s*=\\s*([-+]?\\d+(?:\\.\\d+)?)?[+ - *]{0}$");
        Matcher matcher_2 = pattern.matcher(eqn);
        int isvalid = -1;
        if(matcher_2.matches()) {
            isvalid = 1;
            return isvalid;
        }
        else{
            System.out.println("At least give a valid eqn bro ");
            isvalid = 0;
            return isvalid;
        }
    }
    public static void Coefficient_Extractor(String eqn,int i){
            Pattern pattern_2= Pattern.compile("(-?\\d+)");
            Matcher matcher = pattern_2.matcher(eqn);
            int j=0;
            while (matcher.find()) {
                int in = Integer.parseInt(matcher.group(1));
                arr[i][j] = in;
                j++;
            }
    }
    public static void printarray(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

