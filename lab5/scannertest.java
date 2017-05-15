private ArrayList readInputFile (MyNode root){
    try{
        static Scanner sc = new Scanner(new File("Liv.txt"));
    }
    catch(FileNotFoundException e){
        System.out.println(e);
    }

    while(sc.hasNextLine()){
      String line = sc.nextLine();
      String lineTemp = line.subString(1);

      if(lineTemp.charAt(0).equals("/")){
          return;
}


      else{

        String [] tokens = line.split(">");
        String levelSection = tokens[0];
        String textSection = tokens[1];

        String [] levsectokens =levelSection.split(" ");
        MyNode nod =MyNode(levsectokens[0],textSection);
          }
        }

}
        for(char character: line){
            if(character = )
        }
    }
    attributes[]

    for rad in ("bla.txt"){
        arraylist;
    }
    return attributes;
}
