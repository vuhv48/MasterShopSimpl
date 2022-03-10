package com.mycompany.myapp.service.util;

public class Constants {

    public static final String LOGIN_USER = "login_user";
    public static final String LOGIN_ADMIN = "login_admin";
    public static final String CART = "cart";

    public static class OrderStatus {

        public static final Integer WAIT_PAY = 0;
        public static final Integer PAYED = 1;
        public static final Integer SHIPPED = 2;
        public static final Integer DELETED = 3;
        public static final Integer ENDED = 4;
    }
}
