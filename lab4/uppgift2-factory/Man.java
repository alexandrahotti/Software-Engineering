package human;

class Man extends Human{
  String name;
  String pnr;
  String sex;

protected Man(String name, String pnr){
    this.name = name;
    this.pnr = pnr;
    this.sex = "man";
  }

public String toString(){
    return("Hej mitt namn är " + name + ", och jag är " + sex);
}

}
