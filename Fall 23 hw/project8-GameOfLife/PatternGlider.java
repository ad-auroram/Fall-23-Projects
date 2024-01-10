public class PatternGlider extends Pattern{
    public int getSizeX(){
        return 3;
    }

    public int getSizeY(){
        return 3;
    }

    public boolean getCell(int x, int y){
        boolean[][] glider ={
                {false, false, true},
                {true, false, true},
                {false, true, true}

        };
        return glider[x][y];
    }
}
