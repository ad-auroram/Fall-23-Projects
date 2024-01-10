// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ConwaysLife {
    public static void main(String[] args) {
        PatternGlider glider = new PatternGlider();
        PatternAcorn acorn = new PatternAcorn();
        PatternBlinker blinker = new PatternBlinker();
        PatternBlock block = new PatternBlock();
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();

            TerminalSize size = screen.getTerminalSize();
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());

            simulation.insertPattern(glider, 0,0);
            simulation.insertPattern(acorn, 20,20);
            simulation.insertPattern(blinker, 50, 1);
            simulation.insertPattern(blinker, 55, 10);
            simulation.insertPattern(block, 65, 7);
            simulation.insertPattern(block, 60, 6);

            screen.startScreen();
            screen.setCursorPosition(null);

            for (int i = 0; i < 400; i++) {
                render(simulation, screen, graphics);   // Render the current state of the simulation
                //sampleRender(screen, graphics, i);
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(10);                // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }
/*
    public static void sampleRender(Screen screen, TextGraphics graphics, int xPos) {
        screen.clear();

        // Not very interesting, but showing how to set characters
        graphics.setCharacter(xPos, 10, 'X');

        // This is what causes the console to render the new state, it is required
        try {
            screen.refresh();
        } catch (Exception ex) {
        }
    }

 */
    public static void render(LifeSimulator simulation, Screen screen, TextGraphics graphics){
        screen.clear();
        for (int i = 0; i< simulation.board.length; i++ ){
            for (int j = 0; j< simulation.board[0].length; j++){
                if (simulation.board[i][j] == true){
                    graphics.setCharacter(i, j, '\u25C6');
                }
            }
        }
        try {
            screen.refresh();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }
}
