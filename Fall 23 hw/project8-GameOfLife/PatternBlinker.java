public class PatternBlinker extends Pattern{
    public int getSizeX(){
        return 3;
    }

    public int getSizeY(){
        return 3;
    }

    public boolean getCell(int x, int y){
        boolean[][] blinker = {
                {false,false,false},
                {true, true, true},
                {false,false,false}
        };
        return blinker [x][y];
    }
}
