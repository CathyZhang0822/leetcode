public class CapturesOfRook {
    public static void main(String[] args){
        // AC 了
    }

    public int numRookCaptures(char[][] board){
        int RRow = 0, RCol = 0;
        boolean find = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R'){
                    RRow = i;
                    RCol = j;
                    find = true;
                    break;
                }
            }
            if(find) break;
        }
        int res = 0;
        for(int i = RRow; i>=0; i--){
            if(board[i][RCol] == 'B') break;
            else if(board[i][RCol] == 'p') {

                res ++;
                break;
            }
        }
        for(int i = RRow; i<board.length; i++){
            if(board[i][RCol] == 'B') break;
            else if(board[i][RCol] == 'p') {

                res ++;
                break;
            }
        }
        for(int j = RCol; j<board[0].length; j++){
            if(board[RRow][j] == 'B') break;
            else if(board[RRow][j]  == 'p') {

                res ++;
                break;
            }
        }
        for(int j = RCol; j>=0; j--){
            if(board[RRow][j] == 'B') break;
            else if(board[RRow][j]  == 'p') {

                res ++;
                break;
            }
        }
        return res;
    }
}
