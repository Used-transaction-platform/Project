package com.example.ssafy_book.valueobjects;

public class ReqJoinParams {
    private String email;
    private String passwd;
    private String phone;
    private String eth_id;

    public ReqJoinParams(String email, String passwd, String phone, String eth_id)
    {
        this.email = email;
        this.passwd = passwd;
        this.phone = phone;
        this.eth_id = eth_id;
    }
}
