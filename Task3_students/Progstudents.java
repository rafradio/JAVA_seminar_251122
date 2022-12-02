public class Progstudents {
    public static void main(String[] args) {
        Addclass obj = new Addclass();
        obj.enterString();
        obj.removeSymbols();
        obj.findLength(obj.data);
        System.out.println(obj.lengthArr);
        if (obj.lengthArr > 0) {
            obj.finalArr = new String[obj.lengthArr];
            obj.splitLine();
            obj.creatDetails();
            obj.creatLines();
        }
    }
}
