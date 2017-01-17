package com.example.amitrai.demo.ui.modals;

import java.util.Date;

/**
 * Created by amitrai on 17/1/17.
 * see more at www.github.com/amitrai98
 */

public class MessageModal {
    String message;
    Date date;

    public MessageModal(String message,
            Date date){
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
