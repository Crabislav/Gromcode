package lesson19.homework1;

public class Controller {
    //adds file to storage
    public void put(Storage storage, File file) throws Exception {
        validatePut(storage, file);

        File[] files = storage.getFiles();
        int index = 0;

        for (File element : files) {
            if (element == null) {
                files[index] = file;
                storage.setFiles(files);
                return;
            }
            index++;
        }
    }

    //deletes file from storage
    public void delete(Storage storage, File file) throws Exception {
        int index = 0;

        File[] files = storage.getFiles();

        for (File element : files) {
            if (element != null && element.equals(file)) {
                files[index] = null;
                storage.setFiles(files);
                return;
            }
            index++;
        }

        throw new Exception("file(id=" + file.getId() + ") is absent at" +
                " storage(id=" + storage.getId() + ")");
    }

    //transfers all files from one storage to another
    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        validateTransferAll(storageFrom, storageTo);

        for (File file : storageFrom.getFiles()) {
            put(storageTo, file);
            delete(storageFrom, file);
        }
    }

    //transfers a file from one storage to another
    public void transfer(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File fileToTransfer = null;

        //finds fileToTransfer at storageFrom using id
        for (File element : storageFrom.getFiles()) {
            if (element.getId() == id) {
                fileToTransfer = element;
                break;
            }
        }

        validateTransfer(fileToTransfer, storageFrom, storageTo, id);

        put(storageTo, fileToTransfer);
        delete(storageFrom, fileToTransfer);
    }

    private long calculateUsedStorageMemory(Storage storage) {
        long usedStorageMemory = 0;

        for (File element : storage.getFiles()) {
            if (element != null) {
                usedStorageMemory += element.getSize();
            }
        }

        return usedStorageMemory;
    }

    private void checkUpFileFormat(Storage storage, File file) throws Exception {
        for (String supportedFormat : storage.getFormatsSupported()) {
            if (supportedFormat.equals(file.getFormat())) {
                return;
            }
        }
        throw new Exception("Invalid file(id=" + file.getId() + ") format");
    }

    private void checkUpAllSupportedFormats(Storage storageFrom, Storage storageTo) throws Exception {
        boolean isAllFormatsSupported = false;

        for (String oldValidFormat : storageFrom.getFormatsSupported()) {
            for (String newValidFormat : storageTo.getFormatsSupported()) {
                isAllFormatsSupported = oldValidFormat.equals(newValidFormat);
            }
        }

        if (!isAllFormatsSupported) {
            throw new Exception("New storage(id=" + storageTo.getId() + "doesn't support necessary file formats");
        }
    }

    private long calculateFreeStorageCells(Storage storage) {
        long count = 0;

        for (File element : storage.getFiles()) {
            if (element == null) {
                count++;
            }
        }

        return count;
    }

    private void validateTransferAll(Storage storageFrom, Storage storageTo) throws Exception {
        long storageToId = storageTo.getId();

        //comparing old storage's size with a new one's
        long freeStorageToMemory = storageTo.getStorageSize() - calculateUsedStorageMemory(storageTo);
        if (calculateUsedStorageMemory(storageFrom) > freeStorageToMemory) {
            throw new Exception("new storage(id=" + storageToId + ") hasn't enough space for transferring files from old storage(id=" +
                    storageFrom.getId() + ")");
        }

        checkUpAllSupportedFormats(storageFrom, storageTo);
        checkUpFreeStorageCells(storageTo, storageFrom.getFiles().length);
    }

    private void validateTransfer(File fileToTransfer, Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (fileToTransfer == null) {
            throw new Exception("file with id=" + id + "is absent at storage(id=" + storageFrom.getId() + ")");
        }

        checkUpFileFormat(storageTo, fileToTransfer);
        checkUpFreeStorageCells(storageTo, 1);
    }

    private void checkUpFreeStorageCells(Storage storage, long usedStorageCells) throws Exception {
        if (calculateFreeStorageCells(storage) < usedStorageCells) {
            throw new Exception("Not enough empty cells at new storage(id=" + storage.getId() + ")");
        }
    }

    private void validatePut(Storage storage, File file) throws Exception {
        //no space for file
        if (storage.getStorageSize() < calculateUsedStorageMemory(storage) + file.getSize()) {
            throw new Exception("Not enough space for file(id= " + file.getId() + ") at storage(id= " + storage.getId() + ")");
        }

        checkUpFileFormat(storage, file);
        checkUpFileExisting(storage, file);
    }

    private void checkUpFileExisting(Storage storage, File file) throws Exception {
        long fileId = file.getId();

        for (File element : storage.getFiles()) {
            if (element != null && element.equals(file)) {
                throw new Exception("file(id=" + fileId + ") is already exists at storage(id=" + storage.getId() + ")");
            }
        }
    }


}
