class Solution {
    List<List<String>> res=new ArrayList<List<String>>();
    int size;
    public List<List<String>> solveNQueens(int n) {
        size=n;
        // We implement a function that makes some changes to the state 
        // call itself again and then when the call returns it undoes those changes


        // Row
        // we will place only one queen during each call and we will move onto next row by calling backtrack by incrementing the parameter row+1
        //For Col how do we do this?? 
        // we will use a set 

        // how about daigonal

        // there is a property the difference between row and a col is always contant

        // how about anti-daigonal 

        // sum of row +col is always contants , i will attach the daigrams in our notes

        //
        int row=0;
        // charaacter array to store q... amd ..q. 
        char state[][]=new char[size][size];

        // first we create a empty board with all dots
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                state[i][j]='.';
            }
        }
        // we create hashset to store previously placed queens we create 3 col , daigonals and antidaigonals 
        HashSet<Integer> col=new HashSet<>();
        HashSet<Integer> daig=new HashSet<>(); // we can access all the daigonals by row -col
        HashSet<Integer> anti=new HashSet<>();  // we can access all the antidaigonals by row +col
        backtrack(row,col,daig,anti,state); // we call a recursive function to take care
        return res;
    }

    public List<String> format(char[][]state) //  this is aesthatics 
    {
        List<String> board=new ArrayList<String>();
        for(int a=0;a<size;a++)
        {
            String c=new String(state[a]); // all the char array we put it in the Strinf
            board.add(c);
        }
        return board;
    }

        public void backtrack(int row, HashSet<Integer> col,HashSet<Integer> daig,HashSet<Integer> anti, char [][]state)
        {
            if(row==size) //  so we have placed size-1 which what is required last rwo means we return the value
            {
                res.add(format(state));
                return;
            }
            for(int c=0;c<size;c++) // move it too all the col
            {
                int cd=row-c; // daigonal -> row -col 
                int cad=row+c; // anitdaigonal row +col
                if(col.contains(c)||daig.contains(cd)||anti.contains(cad)) // if it is presnt in the same col or same daigonal or same antidaigonal
                continue;

// this is all about adding the queen
                col.add(c);  //else we add it to the respective hasset
                daig.add(cd);
                anti.add(cad);
                state[row][c]='Q';  // this is the placement of  the queen 

// moving on to the next row
                backtrack(row+1,col,daig,anti,state); // recurssive functiom
   // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call   
                col.remove(c);
                daig.remove(cd);
                anti.remove(cad);
                state[row][c]='.';
            }

        }
}
