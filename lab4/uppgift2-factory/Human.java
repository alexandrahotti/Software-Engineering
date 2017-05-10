import java.lang.*;

abstract class Human{

  //    static String secondLast;
static Human create (String name, String pnr) {

       String secondLast = Character.toString(pnr.charAt(9));
       int secondLastNmbr = Integer.parseInt(secondLast);
        System.out.println(secondLastNmbr);
       if (secondLastNmbr==0){
         NonBinary hen = new NonBinary(name, pnr);
         return hen;
       }
       else if (secondLastNmbr%2==0 & secondLastNmbr!=0){
          Woman woman = new Woman(name,pnr);
          return woman;
       }
       else{
          Man man = new Man(name, pnr);
          return man;
       }
    }
}


// A.getInstance()
