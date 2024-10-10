public class Main {
    public static void main(String[] args) {
//        double[][] x= {{1,1,1},{1,3,1},{2,1,2}};
//        double[][] y= {{6},{10},{10}};
          double[][] x= {{4,5},{3,-5}};
          double[][] y= {{12},{9}};

        Linear_Equations linearEquations= new Linear_Equations(x,y);
        double[][] xy= linearEquations.solve();
        for(int i=0; i<xy.length; i++)
        {
            for(int j=0; j<xy[i].length; j++)
            {
                System.out.println(xy[i][j]+" ");
            }
        }

    }
}
