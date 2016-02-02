public class Lab3
{
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }

  public static void backUp()
  {
    turnAround();
    Robot.move();
    turnAround();
  }
  
  public static void completeBars()
  {
    boolean cont = true;
    while(cont){
      Robot.turnLeft();
      while(!Robot.onDark()){
        Robot.makeDark();
        Robot.move();
      }
      Lab3.turnAround();
      while(Robot.frontIsClear()){
        Robot.move();
      }
      Robot.turnLeft();
      if(Robot.frontIsClear()){
        Robot.move();
      }
      else{
        cont = false;
      }
    }
  }
  
  public static void testCompleteBars1()
  {
    Robot.load("bars1.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void testCompleteBars2()
  {
    Robot.load("bars2.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void combinePiles()
  {
    int count = 0;
    while(Robot.onDark()){
      count++;
      Robot.makeLight();
      if(Robot.frontIsClear()){
        Robot.move();
      }
    }
    Lab3.turnAround();
    while(Robot.frontIsClear()){
      Robot.move();
    }
    Robot.turnLeft();
    Robot.move();
    Robot.turnLeft();
    while(Robot.onDark()){
      Robot.move();
    }
    for(int i = count; i > 0; i--){
      Robot.makeDark();
      if(Robot.frontIsClear()){
        Robot.move();
      }
    }
  }

  public static void testCombinePiles1()
  {
    Robot.load("piles1.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void testCombinePiles2()
  {
    Robot.load("piles2.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void twoMove(){
    Robot.move();
    Robot.move();
  }
  
  public static int probe(){
    Lab3.twoMove();
    if(Robot.onDark()){
      Lab3.turnAround();
      Lab3.twoMove();
      Lab3.turnAround();
      return 0;
    }
    Robot.turnLeft();
    Lab3.twoMove();
    Robot.turnLeft();
    Lab3.twoMove();
    Robot.turnLeft();
    if(Robot.onDark()){
      Lab3.twoMove();
      Robot.turnLeft();
      return 1;
    }
    Lab3.twoMove();
    Lab3.twoMove();
    if(Robot.onDark()){
      Lab3.turnAround();
      Lab3.twoMove();
      Lab3.turnRight();
      return 2;
    }
    Lab3.turnAround();
    Lab3.twoMove();
    Lab3.turnRight();
    return 42;
  }
  
  public static void fill(){
    Robot.move();
    Robot.makeDark();
    Robot.move();
  }
  
  public static void connectDots()
  {
    boolean cont = true;
    while(cont){
      int probe = Lab3.probe();
      if(probe == 0){
        Lab3.fill();
      }
      else if(probe == 1){
        Robot.turnLeft();
        Lab3.fill();
      }
      else if(probe == 2){
        Lab3.turnRight();
        Lab3.fill();
      }
      else{
        cont = false;
      }
    }
  }
  
  public static void testConnectDots1()
  {
    Robot.load("connect1.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  
  public static void testConnectDots2()
  {
    Robot.load("connect2.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  
  /*BONUS MATERIAL!!!!!! Please make YOUR OWN text file for testing purposes. I have my own for grading.
   * Also, please make your own tester method. I will simply call Lab3.sort() from my Robot.test file,
   * so if you are loading your test file in that method, I will encounter an error and you
   * will not receive credit.*/
  
  public static void condDark(){
    if(!Robot.onDark()){
      Robot.makeDark();
    }
  }
  
  public static void sort(){
    Robot.load("sort.txt");
    Robot.setDelay(0.025);
    boolean cont = true;
    while(cont){
      Lab3.condDark();
      Robot.move();
      Lab3.condDark();
      Robot.turnLeft();
      Robot.move();
      Lab3.condDark();
      Robot.move();
      if(Robot.onDark()){
        Robot.makeLight();
      }
      Lab3.turnAround();
      Robot.move();
      Robot.move();
      Robot.turnLeft();
      Robot.move();
      Lab3.condDark();
      if(!Robot.frontIsClear()){
        cont = false;
      }
    }
  }
  
   
}