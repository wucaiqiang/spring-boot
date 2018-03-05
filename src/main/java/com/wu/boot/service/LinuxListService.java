package com.wu.boot.service;

public class LinuxListService implements ListService{
    @Override
    public String listCmd() throws Exception {
        return "ls";
    }
}
