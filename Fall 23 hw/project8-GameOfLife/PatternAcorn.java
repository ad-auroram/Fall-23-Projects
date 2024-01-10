public class PatternAcorn extends Pattern{

    public int getSizeX(){
        return 7;
    }

    public int getSizeY(){
        return 3;
    }

    public boolean getCell(int x, int y){
        boolean[][] acorn = {
                {true, false, false},
                {true, false, true},
                {false, false, false},
                {false, true, false},
                {true, false, false},
                {true, false, false},
                {true, false, false}
        };
        return acorn[x][y];
    }
}

