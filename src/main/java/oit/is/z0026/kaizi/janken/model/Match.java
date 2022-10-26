package oit.is.z0026.kaizi.janken.model;

public class Match {
    int id;
    String user1;
    String user2;
    String user1Hand;
    String user2Hand;
    boolean isActive;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUser1() {
        return user1;
    }
    public void setUser1(String user1) {
        this.user1 = user1;
    }
    public String getUser2() {
        return user2;
    }
    public void setUser2(String user2) {
        this.user2 = user2;
    }
    public String getUser1Hand() {
        return user1Hand;
    }
    public void setUser1Hand(String user1Hand) {
        this.user1Hand = user1Hand;
    }
    public String getUser2Hand() {
        return user2Hand;
    }
    public void setUser2Hand(String user2Hand) {
        this.user2Hand = user2Hand;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    
}

