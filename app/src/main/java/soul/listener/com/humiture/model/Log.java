package soul.listener.com.humiture.model;

/**
 * @author kuan
 *         Created on 2017/11/14.
 * @description
 */

public class Log {
    String id;
    String userId;
    String operation;
    String currentTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", operation='" + operation + '\'' +
                ", currentTime='" + currentTime + '\'' +
                '}';
    }
}
