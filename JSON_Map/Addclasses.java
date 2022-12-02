import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Addclasses {
    public String data;
    public String[][] finalArray;
    public void enterString() {

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            this.data = myReader.nextLine();
            myReader.close();

          } catch (FileNotFoundException e) {
            
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }

    public void removeSymbols() {

        this.data = this.data.replaceAll("\\s", "");
        this.data = this.data.replaceAll("\\{", "");
        this.data = this.data.replaceAll("\\}", "");
    }

    public void splitLine() {
        String[] premilArray = this.data.split("\\,");
        int lengthArr = premilArray.length;
        this.finalArray = new String[lengthArr][2];
        
        for (int i = 0; i < lengthArr; i++) {
            this.finalArray[i] = premilArray[i].split("\\:");
        }
    }

    public void buildSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM students WHERE ");
        for (int i = 0; i < this.finalArray.length; i++) {
            // if (!(this.finalArray[i][1] == "null"))) {
            if (!(this.finalArray[i][1].contains("\"null\""))) {
                sb.append(this.finalArray[i][0].replaceAll("\"", ""));
                sb.append("=");
                sb.append(this.finalArray[i][1]);
                if (i == this.finalArray.length - 1) {
                    sb.append(";");
                } else {
                    sb.append(" AND ");
                }
            } else if (i == this.finalArray.length - 1) {
                sb.append(";");
            }
        }
        String finalString = sb.toString();
        if (finalString.endsWith(" AND ;")) {
            finalString = finalString.replace(" AND ;", ";");
        }
        System.out.println(finalString);


    }
    
}
