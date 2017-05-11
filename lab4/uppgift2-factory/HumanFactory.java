//Helena Rosenzweig & Alexandra Hotti
import human.Human;

public class HumanFactory{

public static void main(String[]args){
  Human alex = Human.create("Alex","950128-9801");
  //new Human(){};
  System.out.println(alex);
//  TESTFALL SOM INTE FUNGERAR:
  //Human human = new Human("950128-9801");
//  Man man = new Man("Peter", "950128-9801");
  }
}

// För att kompilera ett package
// javac human/*.java
// Kompilera med "javac human/*.java" i /uppgift2-factory nivån3333333333
