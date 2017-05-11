//Helena Rosenzweig & Alexandra Hotti

public class CompositeTester{

public static void main(String args[]){
    CompositeSuitcase2 väska = new CompositeSuitcase2(5,"douchebag");

    CompositeSuitcase2 necessär = new CompositeSuitcase2(2,"necessär");
    Leaf tandborste = new Leaf(1,"tandborste");
    Leaf deo = new Leaf(1,"deo");
    CompositeSuitcase2 ask = new CompositeSuitcase2(1,"ask");
    Leaf nål =new Leaf(1,"nål");
    //ask.add(nål);

    CompositeSuitcase2 plånbok =new CompositeSuitcase2(2,"plånbok");
    ask.addcomp(plånbok);
    plånbok.addcomp(nål);


    necessär.addcomp(tandborste);
    necessär.addcomp(deo);
    necessär.addcomp(ask);

    väska.addcomp(necessär);

    Leaf tröja = new Leaf(2,"tröja");
    Leaf byxa = new Leaf(2,"byxor");

    väska.addcomp(tröja);
    väska.addcomp(byxa);

    //System.out.println(necessär.compType+ " comptype necessär");
    //System.out.println(deo.compType+ " comptype deo");
  //  System.out.println(necessär.toString());
    //System.out.println(necessär);
    System.out.println(väska);
  
}
}
