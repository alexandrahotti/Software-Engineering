public class HumanFactory extends Human{



public static void main(String[]args){
  Human alex = Human.create("Alex","950128-9821");
  Human adam = Human.create("Adam","970128-9831");
  Human kim = Human.create("Kim","910304-9801");
  new Human(){
  };
  System.out.println(alex);
  System.out.println(adam);
  System.out.println(kim);
//  TESTFALL SOM INTE FUNGERAR:
//  Human human = new Human("950128-9801");
}

}
