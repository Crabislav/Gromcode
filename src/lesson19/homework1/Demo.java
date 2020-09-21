package lesson19.homework1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();

//        putDeleteTest(controller);

        File file1 = new File(0, "file0", "pdf", 100);
        File file2 = new File(1, "file1", "jpg", 100);
        File file3 = new File(2, "file2", "jpg", 100);
//        File file4 = new File(3, "file3", "jpg", 100);

        File[] files = {file1, file2, file3};
        File[] emptyFiles = new File[3];

        Storage storage = new Storage(0, files, new String[]{"pdf", "jpg"}, "Russia", 300);
        Storage emptyStorage = new Storage(2, emptyFiles, new String[]{"pdf", "jpg"}, "Russia", 300);


        //transferAll test
        System.out.println("Before transfer all");
        System.out.println("Old storage");
        System.out.println(Arrays.toString(storage.getFiles()));
        System.out.println("New storage storage");
        System.out.println(Arrays.toString(emptyStorage.getFiles()));
        try {
            controller.transferAll(storage, emptyStorage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nAfter transfer all");
        System.out.println("Old storage");
        System.out.println(Arrays.toString(storage.getFiles()));
        System.out.println("New storage storage");

        System.out.println(Arrays.toString(emptyStorage.getFiles()));

//        transferMethodTest(controller, storage, emptyStorage);
    }

    private static File[] generateFiles(int amount, String fileName, String fileFormat, long fileSize) throws Exception {
        File[] resultArray = new File[amount];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = new File(i, fileName + i, fileFormat, fileSize);
        }

        return resultArray;
    }

    private static void putDeleteTest(Controller controller) throws Exception {
        // size == 5 * 200 == 1000
        File[] txtFiles = generateFiles(5, "text", "txt", 200);
        Storage txtStorage = new Storage(1, txtFiles, new String[]{"txt", "superTxt"}, "Ukraine", 1000);

        //deleting an existing file
        try {
            controller.delete(txtStorage, txtStorage.getFiles()[1]); //id = 1
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(txtStorage.getFiles()));

        //put method test
        File validFileToPut = new File(1, "text1", "txt", 200);
        try {
            controller.put(txtStorage, validFileToPut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(txtStorage.getFiles()));

        //put the same file into full storage
        try {
            controller.put(txtStorage, validFileToPut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //put file with existing id
        File wrongIdFile = new File(1, "text1", "txt", 200);
        try {
            controller.delete(txtStorage, txtStorage.getFiles()[0]);
            controller.put(txtStorage, wrongIdFile);
            System.out.println(Arrays.toString(txtStorage.getFiles()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void transferMethodTest(Controller controller, Storage storageFrom, Storage storageTo) {
        System.out.println(Arrays.toString(storageFrom.getFiles()));
        try {
            controller.transfer(storageFrom, storageTo, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(storageFrom.getFiles()));
        System.out.println(Arrays.toString(storageTo.getFiles()));

    }
}
