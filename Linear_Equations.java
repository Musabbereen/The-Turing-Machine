public class Linear_Equations {
    private double[][] Coeffs;
    private double[][] RHS;
    Linear_Equations(double[][] Coeffs, double[][] RHS) {
        this.Coeffs = Coeffs;
        this.RHS = RHS;
    }
    public double[][] solve(){
        int x= Coeffs.length;
        double[][] augmentedMatrix= new double[x][x+1];
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                augmentedMatrix[i][j]= Coeffs[i][j];
            }
            augmentedMatrix[i][x]= RHS[i][0];
        }
        int n = augmentedMatrix.length;

        // Forward elimination
        for (int i = 0; i < n - 1; i++) {
            // Find the pivot row
            int pivotRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(augmentedMatrix[j][i]) > Math.abs(augmentedMatrix[pivotRow][i]))
                {
                    pivotRow = j;
                }
            }

            // Swap rows if necessary
            if (i != pivotRow) {
                double[] temp = augmentedMatrix[i];
                augmentedMatrix[i] = augmentedMatrix[pivotRow];
                augmentedMatrix[pivotRow] = temp;
            }

            // Eliminate below the pivot
            for (int j = i + 1; j < n; j++) {
                double factor = augmentedMatrix[j][i] / augmentedMatrix[i][i];
                for (int k = i + 1; k <= n; k++) {
                    augmentedMatrix[j][k] -= factor * augmentedMatrix[i][k];
                }
            }
        }

        // Backward substitution
        for (int i = n - 1; i >= 0; i--) {
            double sum = augmentedMatrix[i][n];
            for (int j = i + 1; j < n; j++) {
                sum -= augmentedMatrix[i][j] * augmentedMatrix[j][n];
            }
            augmentedMatrix[i][n] = sum / augmentedMatrix[i][i];
        }
        return augmentedMatrix;
    }
}
