public class RobotTest
{
  public static void main(String[]args)
  {
    Lab3.testCompleteBars1();
    Grid.pauseUntilMouse();
    Lab3.testCompleteBars2();
    Grid.pauseUntilMouse();
    Lab3.testCombinePiles1();
    Grid.pauseUntilMouse();
    Lab3.testCombinePiles2();
    Grid.pauseUntilMouse();
    Lab3.testConnectDots1();
    Grid.pauseUntilMouse();
    Lab3.testConnectDots2();
    Grid.pauseUntilMouse();
    
    
    //EXTRA FUN
    Robot.load("sort.txt");
    Lab3.sort();
   
    
  }
}