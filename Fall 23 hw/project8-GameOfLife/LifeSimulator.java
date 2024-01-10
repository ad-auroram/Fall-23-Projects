public class LifeSimulator {
    boolean[][] board;
    public LifeSimulator(int sizeX, int sizeY) {
        this.board = new boolean[sizeX][sizeY];
        for (int i = 0; i <sizeX; i ++){
            for (int j = 0; j<sizeY; j++){
                board[i][j]=false;
            }
        }
    }

    public int getSizeX() {
        return board.length;
    }
    public int getSizeY() {
        return board[0].length;
    }
    public boolean getCell(int x, int y) {
        return board[x][y];
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        int sizeX = pattern.getSizeX();
        int sizeY = pattern.getSizeY();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                board[i+startX][j+startY] = pattern.getCell(i, j);
            }
        }
    }

    public int neighborCount(boolean[][] board, int x, int y){
        int neighbor = 0;
        int left = x-1;
        if (left<=0){
            left = 0;
        }
        int right = x+2;
        if(right >= board.length){
            right = board.length;
        }
        int up = y-1;
        if (up<=0){
            up = 0;
        }
        int down = y+2;
        if(down>=board[0].length){
            down = board[0].length;
        }
        for (int i = left; i<right; i++){
            for (int j = up; j<down; j++){
                if (board[i][j]==true){
                    neighbor +=1;
                }
            }
        }
        if (board[x][y] == true) {
            neighbor -= 1;
        }
        if (neighbor < 0){
            neighbor = 0;
        }
        return neighbor;
    }

    public void update() {
        boolean[][] nextBoard = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int n = neighborCount(board, i, j);
                if (board[i][j]==true && n == 2 || n == 3) {
                    nextBoard[i][j] = true;
                } else if (board[i][j] == false && n == 3) {
                    nextBoard[i][j] = true;
                } else {
                    nextBoard[i][j] = false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }
}


