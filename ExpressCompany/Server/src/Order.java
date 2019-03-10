import java.io.Serializable;
import java.sql.Timestamp;

// A Order class only for testing the rmi function.
public class Order implements Serializable {
    private int id;
    private Timestamp time;
    private byte status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }


    public Order(){
        id = 0;
        time = null;
        status = 0;
    }

}
