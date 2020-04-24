package com.shekhar.demo.mvvmdatabindinglivedatademo.network;

import java.io.IOException;

public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No Internet found";
    }
}