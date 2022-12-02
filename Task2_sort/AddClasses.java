import java.io.File;  
import java.io.IOException;  
import java.util.logging.*;
import java.util.logging.FileHandler;

public class AddClasses {
    public int[] arrInitial;
    public Logger loggingAtrr;

    public AddClasses(int[] arr) {
        this.arrInitial = arr;
        Logger logger = Logger.getLogger(AddClasses.class.getName());
        this.loggingAtrr = logger;
        this.loggingAtrr.setLevel(Level.ALL);
        
        
    }

    public void creatLogFile() {
        try {
            File myFile = new File("logfile.txt");
            myFile.createNewFile();
            FileHandler fileHandler = new FileHandler("logfile.txt", true);
            SimpleFormatter sFormat = new SimpleFormatter();
            fileHandler.setFormatter(sFormat);
            this.loggingAtrr.addHandler(fileHandler);
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    public void sortArray() {
        
        int iter = 1;
        for (int i = 0; i < this.arrInitial.length; i++) {
            boolean isChanged = true;
            for (int j = 0; j < this.arrInitial.length - 1 - i; j++) {
                if (this.arrInitial[j] > this.arrInitial[j + 1]) {
                    int max = this.arrInitial[j];
                    this.arrInitial[j] = this.arrInitial[j + 1];
                    this.arrInitial[j + 1] = max;
                    isChanged = false;
                }
            }
            String logString = "Произведена " + iter + "-ая итерация";
            this.loggingAtrr.log(Level.INFO, logString);
            if (isChanged) {break;}
            iter += 1;
        }
    }

    public void addLogging(String note, int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i: arr) {
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        this.loggingAtrr.log(Level.INFO, note);
        this.loggingAtrr.log(Level.INFO, sb.toString());

    }
}
