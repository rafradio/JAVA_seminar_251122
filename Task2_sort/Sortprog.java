public class Sortprog {
    public static void main(String[] args) {
        int[] arr = {7, 6, 3, 2, 3, 10, 15, 8};
        
        AddClasses obj = new AddClasses(arr);
        obj.creatLogFile();
        obj.addLogging("Первоначальный массив: ", arr);
        obj.sortArray();
        obj.addLogging("Сортированный массив: ", obj.arrInitial);

    }
}