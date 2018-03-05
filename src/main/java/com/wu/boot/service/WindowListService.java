package com.wu.boot.service;

public class WindowListService implements  ListService{
    @Override
    public String listCmd() throws Exception {
        return "dir";
    }
}
