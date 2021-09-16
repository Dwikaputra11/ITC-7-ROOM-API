package com.example.itc_databaseapiproject.service;

public interface FootballListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
