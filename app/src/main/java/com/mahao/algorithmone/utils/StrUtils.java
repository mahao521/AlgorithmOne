package com.mahao.algorithmone.utils;

import java.util.Arrays;

import static android.R.attr.max;

/**
 * Created by Penghy on 2017/2/20.
 */


public class StrUtils {


    //字符串的静态存储结构
    int  maxLen = 100;              //最大长度
    char[] chs = new char[maxLen];
    int currentLen ;                //串长度



    public  static void  main(String[] args){

        String str = "mynameismahao";
        String strOne = "i love my family , but i don't hava a family";

        //拼接字符串
        String totalStr = concatString(str,strOne);
        System.out.println("----" + totalStr);

        //将一个字符串中的部分拼接到另一个上
        String newLine = subString("i love family ","mahao",0,5);
        System.out.println(newLine);

        //查找字符串中字母出现的频率
        int[] numbCount = findNumCount("kskkskkkssfjalsdfjalsdfjas");
        for(int i = 0; i < numbCount.length; i++){

            System.out.print(numbCount[i] + ".....");
        }

        //顺序表的逆置
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        inverse(a);
        System.out.print("\n"+Arrays.toString(a));

    }

    //字符串的拼接算法
    public static String concatString(String one,String two){

        String str = null;
        int  maxLen = 20;

        //第一种情形
        if(one.length() + two.length() < maxLen){

            str = one + two;
        }

        //第二种情形
        if(one.length() + two.length() > maxLen && one.length() < maxLen){

            String currentTwo = two.substring(0,maxLen - one.length());
            str = one + currentTwo;
        }

        //第三种情形
        if(one.length() > maxLen){

            str = one.substring(0,one.length());
        }
        return str;
    }

    //求子串算法
    public static String subString(String sub,String s, int start ,int len){


        if(sub.length() == 0){

            return null;
        }

        if((start >= 0  && start < s.length()) && (len >= 0 && len <= s.length() - start)){


            char[] temp = s.toCharArray();

            for(int i = start; i < start +len ; i++){

                sub = sub + temp[i];
            }
        }
        return sub;
    }


    //找到一串字符串中字母出现的频率
    public static int[] findNumCount(String text){

        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //用于存放变量的个数
        int[] numbCount = new int[26];

        char[] chs = text.toCharArray();
        for(int i = 0; i < chs.length; i++){

            char ch = chs[i];
            int index = str1.indexOf(ch);
            if(index == -1){

                index = str2.indexOf(ch);
            }

            if(index >= 0){
               numbCount[index]++;
            }
        }
        return numbCount;
    }

    //顺序表的逆置
    public static int[]  inverse(int[] a){

        int t;
        for(int i = 0; i < a.length/2 ; i++){

            t = a[i];
            a[i] = a[a.length - i -1];
            a[a.length - i -1] = t;
        }
        return  a;
    }

}
