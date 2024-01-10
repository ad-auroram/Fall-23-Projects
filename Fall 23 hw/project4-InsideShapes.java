/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {

        // do not change these
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        //loop over circles and points
        //loop over rectangles and points
        /* for circles
            for points
                report point, isPointInside report circle,
           for rectangles
             for points
                report points, is PointInside, report circle
         */
        //loop over circles and points
        System.out.println(" --- Report of Points and Circles --- \n");
        for (int i=0;i<circleX.length;i++){
            for (int j=0; j<ptX.length; j++){
                reportPoint(ptX[j],ptY[j]);
                boolean test1 = isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i]);
                if (test1){
                    System.out.print(" is inside ");
                }
                else{
                    System.out.print(" is outside ");
                }
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
                System.out.println();
            }
        }
        //loop over rectangles and points
        System.out.println("\n --- Report of Points and Rectangles --- \n");
        for (int i=0; i<rectLeft.length; i++){
            for (int j=0; j<ptX.length; j++){
                reportPoint(ptX[j],ptY[j]);
                boolean test2 = isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                if (test2){
                    System.out.print(" is inside ");
                }
                else{
                    System.out.print(" is outside ");
                }
                reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                System.out.println();
            }
        }

    }
    public static void reportPoint(double x, double y){
        //prints details for a point
        System.out.printf("Point(%.1f, %.1f)", x,y);
    }

    public static void reportCircle(double x, double y, double r){
        //prints details for a circle
        System.out.printf("Circle(%.1f, %.1f) Radius: %.1f", x,y,r);
    }

    static void reportRectangle(double left, double top, double width, double height){
        //prints details for a rectangle
        System.out.printf("Rectangle(%.1f, %.1f, %.1f, %.1f)",left, top, left+width, top-height);
    }

    static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius){
        //tests if point is in a circle
        //fix for whichever is the bigger value
        double distance = Math.sqrt(Math.pow((Math.max(ptX,circleX)-Math.min(ptX,circleX)),2)+Math.pow((Math.max(ptY,circleY)-Math.min(ptY,circleY)),2));
        //double distance = Math.sqrt(Math.pow((ptX-circleX),2)-Math.pow((ptY-circleY),2));
        if (distance<=circleRadius){
            return true;
        }else{
            return false;
        }

    }

    static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        //tests if a point is in a rectangle
        //if point is in range left to right and top to bottom return true
        double right = rLeft + rWidth;
        double bottom = rTop - rHeight;
        if (rLeft <= ptX && ptX <= right) {
            if (bottom <= ptY && ptY <= rTop) {
                return true;
            }
        }
        return false;
    }
}
