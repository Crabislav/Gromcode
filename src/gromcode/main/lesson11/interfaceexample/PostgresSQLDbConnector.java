package gromcode.main.lesson11.interfaceexample;

public class PostgresSQLDbConnector implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic for PostgresSQL
    }

    @Override
    public void disconnectFromDb() {
        //some logic for PostgresSQL
    }

    @Override
    public void encryptData() {
        //some logic for PostgresSQL
    }


}
