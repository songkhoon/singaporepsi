package com.songkhoon.singaporepsi.model;

public interface IDataCallback<T> {
    void success(T data);

    void error(Exception error);
}
