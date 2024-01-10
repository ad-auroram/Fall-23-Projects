public class PatternBlock extends Pattern{
    public int getSizeX(){
        return 2;
    }

    public int getSizeY(){
        return 2;
    }

    public boolean getCell(int x, int y){
        boolean[][] block = {
                {true,true},
                {true,true}
        };
        return block[x][y];
    }
}
