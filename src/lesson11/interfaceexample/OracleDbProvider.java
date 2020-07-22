package lesson11.interfaceexample;

public class OracleDbProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic for OracleDB
    }

    @Override
    public void disconnectFromDb() {
        //some logic for OracleDB
    }

    @Override
    public void encryptData() {
        //some logic for OracleDB
    }
}
