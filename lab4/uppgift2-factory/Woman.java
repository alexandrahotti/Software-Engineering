
class Woman extends Human{

String name;
String pnr;
String sex;

Woman(String name, String pnr){
  this.name = name;
  this.pnr = pnr;
  this.sex = "icke-binär";
}

public String toString(){
    return("Hej mitt namn är " + name + ", och jag är " + sex);
}

}
