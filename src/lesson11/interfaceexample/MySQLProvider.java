package lesson11.interfaceexample;

public class MySQLProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic for MySQL
    }

    @Override
    public void disconnectFromDb() {
        //some logic for MySQL
    }

    @Override
    public void encryptData() {
        //some logic for MySQL
    }
}
