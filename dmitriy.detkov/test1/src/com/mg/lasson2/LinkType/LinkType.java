package com.mg.lasson2.LinkType;

public class LinkType {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        String str3 = "";

        str3 = str1.concat(" ");
        str3 = str3.concat(str2);

        System.out.print(str3);
    }
}