import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Addclass {
    public String data;
    public int index = 0;
    public int lengthArr = 0;
    public String[] finalArr;
    public String[][][] detailArr;
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
        this.data = this.data.replaceAll("\\[", "");
        this.data = this.data.replaceAll("\\]", "");
    }

    public void splitLine() {
        if (this.data.contains("{") && this.data.contains("}")) {
            int index1 = this.data.indexOf("{");
            int index2 = this.data.indexOf("}");
            this.finalArr[this.index] = this.data.substring(index1+1, index2);
            this.index += 1;
            this.data = this.data.substring(index2+1, this.data.length());
            this.splitLine();
        } else {
            return;
        }

    }

    public void findLength(String dataStr) {
        if (dataStr.contains("{") && dataStr.contains("}")) {
            int indexChar = dataStr.indexOf("}");
            dataStr = dataStr.substring(indexChar+1, dataStr.length());
            this.lengthArr += 1;
            this.findLength(dataStr);
        } else {
            return;
        }
  
    }

    public void creatDetails() {
        this.detailArr = new String[this.lengthArr][3][2];
        
        for (int i = 0; i < this.lengthArr; i++) {
            String[] newArr = this.finalArr[i].split("\\,");
            for (int j = 0; j < newArr.length; j++) {
                this.detailArr[i][j] = newArr[j].split("\\:");
            }
        }

    }

    public void creatLines() {
        String[] notations = {"Студент "," получил ", " по предмету "};

        for (int i = 0; i < this.lengthArr; i++) { 
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < notations.length; j++) {
                sb.append(notations[j]);
                sb.append(this.detailArr[i][j][1].replaceAll("\"", ""));     
            }
            sb.append(".");
            System.out.println(sb.toString());
        }
    
    }
    
}
