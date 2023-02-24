package com.leasig_firm.leasing.exception;

public class UserNotFoundException extends Exception {
    private int id;
    public UserNotFoundException(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "UserNotFoundException{" +
                "id=" + id +
                '}';
    }
}
