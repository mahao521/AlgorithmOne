package com.mahao.algorithmone.utils;

import java.util.Scanner;

import static android.R.string.no;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Penghy on 2017/2/17.
 */

public class LnodeUtils {


    public char data;

    public LnodeUtils next;    //LnodeUtils 为节点类型

    //头插法
    public static LnodeUtils headInsert(){

        char ch ;  //获取数据
        LnodeUtils node  = null;

        //建立头结点
        LnodeUtils head = new LnodeUtils();
        head.next = null;

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i = 0;

        while (i < str.length()){

            ch = str.charAt(i);
            node = new LnodeUtils();
            node.data = ch;
            node.next = head.next;
            head.next = node;
            i++;
        }

        return node;
    }

    //尾插法
    public static LnodeUtils footInsert(){

        LnodeUtils node,index;
        LnodeUtils head = new LnodeUtils();

        index = head;
        head.next = null;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int i = 0;
        while(i < str.length()){

            char ch = str.charAt(i);
            node = new LnodeUtils();
            node.data = ch;
            node.next = null;
            index.next = node;
            index = node;
            i++;
        }

        return head;
    }

    public static void main(String[] args){

        //头插法----------将字符串翻转
       // setNode(headInsert());

        //尾插法----------将字符串的顺序不变
       // setNode(footInsert());

        //setNode(insertElement(2,'0'));

        //删除链表的指定位置的节点
        setNode(deleteElement(3));

    }

    //遍历整个node
    public static void setNode(LnodeUtils node){

        while(node.next != null){

            System.out.print(node.data+"...");
            node = node.next;
        }
    }

        //在单链表的第I个元素之前插入一个元素的算法
      public  static  LnodeUtils insertElement(int i, char x){

          LnodeUtils p,s;
          char[] chs = new char[]{'a','b','c','d','e','f','g','h','i','j','k','m','n'};
          //生成一个链表
          s = new LnodeUtils();
         for(int j = 0; j < 11; j++){

             p = new LnodeUtils();
             p.data = chs[j];
             p.next = s.next;
             s.next = p;

         }
        //  setNode(s);

          //声明一个index; 指向i-1；
          LnodeUtils index = new LnodeUtils();

          //找到第i-1个元素
         for(int z = 0; z < i; z++){

             if(s.next != null){

                 s = s.next;  //s指向第i-1个元素
                 if(z == i-1){

                     index.data = x;
                     index.next = s.next;
                     s.next = index;
                 }
             }
         }
          return s ;
   }


    //删除指定位置上的节点
    public static  LnodeUtils deleteElement(int i){


        //生成一个链表 ----尾插法
        char[] chs  = new char[]{'1','2','3','4','5','6','7','8','9','a','d','c','d'};

        LnodeUtils index = new LnodeUtils();
        LnodeUtils data;
        LnodeUtils head = new LnodeUtils();
        index = head;
        int j = 0;

        //创建一个链表
        while(j < chs.length){

            data = new LnodeUtils();
            data.data = chs[j];
            data.next = null;
            index.next = data;  // index 代表head;'
            index = data;
            j++;
        }
        
          setNode(head);

        LnodeUtils removeIndex = new LnodeUtils();
        removeIndex = head;

        //指定位置的P
        for(int z = 0; z < i ; z++){

            removeIndex = removeIndex.next;

            if(z == i-1){

               LnodeUtils temp  = new LnodeUtils();
               temp = removeIndex.next;
                removeIndex.next = temp.next;
                temp = null;
            }
        }
        return head;

    }


}





















