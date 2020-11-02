package gromcode.main.lesson18.exercise1;

public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        String[] fileNames = {"test1", "test2"};
        fileStorage.setFiles(fileNames);


        System.out.println("Start printing name...");

        printer(fileStorage);
//        printerNoTryCatch(fileStorage);

        System.out.println("Done");


        String[] fileNames1 = {"test1", "test2", "test3", "test4", "test5"};
        fileStorage.setFiles(fileNames1);
        printer(fileStorage);
        printerNoTryCatch(fileStorage);

        String[] fileNames2 = null;
        fileStorage.setFiles(fileNames2);
        printer(fileStorage);
        printerNoTryCatch(fileStorage);

    }

    public static void printer(Storage storage) {
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e) {
            System.err.println("5th name can not be found...");
//            System.err.println(e.getMessage());
        }
    }

    //handle without try/catch
    public static void printerNoTryCatch(Storage storage) {
        if (storage == null || storage.getFiles() == null) {
            System.err.println("5th name can not be found...");
            return;
        }

        String[] names = storage.getFiles();
        int index = 4;

        if (index > names.length) {
            System.err.println("5th name can not be found...");
        } else {
            System.out.println("5th name is " + names[index]);
        }
    }
}
