package task2;

public class Task2 {
    public static void main(String[] args) {
        int[][] field ={
                {4, 4, 4, 4},
                {4, 2, 2, 4},
                {4, 2, 2, 4},
                {2, 1, 1, 2},
                {2, 4, 2, 2},
        };

        int[][] field0 ={
                {4, 4, 2, 2},
                {4, 2, 1, 4},
                {4, 2, 1, 2},
                {4, 2, 1, 2},
                {4, 4, 2, 2},
        };
        int[][] field1 ={
                {1, 2, 2, 3},
                {2, 1, 1, 4},
                {4, 5, 6, 2},
        };
        int[][] field2 ={
                {2, 2, 3, 2},
                {3, 1, 2, 4},
                {4, 3, 3, 2},
        };

        int[][] field3 ={
                {2, 3, 4, 2},
                {2, 1, 3, 4},
                {3, 2, 3, 2},
                {2, 4, 2, 2},
        };

        int[][] field4 ={
                {3, 3, 3, 3},
                {3, 1, 3, 3},
                {3, 2, 1, 2},
                {3, 3, 3, 2},
        };
        int[][] field5 ={
                {3, 3, 3, 3},
                {3, 3, 1, 3},
                {3, 1, 2, 3},
                {3, 3, 2, 2},
        };

    print(findWater(field));
        System.out.println();
        print(findWater(field0));
        System.out.println();
       print(findWater(field1));
        System.out.println();
        print(findWater(field2));
        System.out.println();
        print(findWater(field3));
        System.out.println();
        print(findWater(field4));
        System.out.println();
        print(findWater(field5));


    }
    public  static int[][] findWater (int[][] field){
        if (field== null)
            return null;
        int [][] water = new int [field.length] [field[0].length] ;

               for (int k = 0; k<field.length; k++){
                    for (int z = 0; z< field[0].length; z++){
                        int up = 0;
                        int down = 0;
                        int right =0;
                        int left = 0;
                        if (k == 0 || k == field.length-1 || z == 0 || z == field[0].length-1 || field[k][z] == 0)
                         water[k][z] = 0;
                       else {
                        for (int m = z-1; m>=0; m--){
                             if (field[k][m] == 0)
                            {water[k][z] = 0;
                            break;}
                            if (field[k][m]>= field[k][m+1]){
                                if (field[k][m]>left)
                                    left= field[k][m];
                            }
                            else{
                                if (left>0)
                                    left = left;
                                else
                                left = 0; }
                        }
                        for (int n = z+1; n< field[k].length; n++){
                            if (field[k][n] == 0)
                            {  water[k][z] = 0;
                            break;}
                            if (field[k][n]>= field[k][n-1]  ){
                                if (field[k][n]>right)
                                    right = field[k][n];
                            }
                            else{
                                if (right>0)
                                    right = right;
                                else
                                    right = 0; }
                        }
                        for (int q=k-1; q>=0; q--){
                             if (field[q][z]==0)
                            { water[k][z] = 0;
                            break;}
                            if (field[q][z]>=field[q+1][z]){
                                if (field[q][z]>up)
                                    up = field[q][z];
                            }
                            else{
                                if (up>0)
                                    up = up;
                                else
                                    up = 0; }
                        }

                        for (int r = k+1; r< field.length; r++){
                            if (field[r][z]==0)
                            { water[k][z] = 0;
                            break;}
                            if (field[r][z]>=field[r-1][z]){
                                if (field[r][z]>down)
                                    down = field[r][z]; }
                            else{
                                if (down>0)
                                    down = down;
                                else
                                    down = 0; }

                        }
                        int min = Math.min(Math.min(up,down), Math.min(right,left));
                        if (min == field[k][z])
                        {water[k][z] = 0;
                            if (water[k][z-1]>=water[k][z])
                            { water[k][z-1]=min;
                            if (water[k][z-1] == field[k][z-1])
                                water[k][z-1]=0; }
                            if (water[k-1][z]>=water[k][z])
                            { water[k-1][z]=min;
                             if (water[k-1][z]==field[k-1][z])
                            water[k-1][z]=0;}
                            }
                         else if(field[k][z]>=water[k][z-1] && z-1!=0 && min>field[k][z-1] )
                            water[k][z] = 0;
                         else if( field[k][z]>=water[k-1][z] && k-1!=0 && min>field[k-1][z])
                              water[k][z] = 0;
                         else
                            water[k][z] = min;

                     if ( water[k][z] < water[k-1][z] && field[k][z] < field[k-1][z])
                        water[k-1][z] = 0;
                     if ( water[k][z] <water[k][z-1] && field[k][z] <field[k][z-1] )
                          water[k][z-1] = 0;
                    }}
                }

        return water ;
    }
    static void print (int[][] water){
        for (int i = 0; i<water.length; i++){
            for (int j = 0 ; j< water[0].length; j++){
                System.out.print(water[i][j] +" ");
            }
            System.out.println();
        }
    }
}
