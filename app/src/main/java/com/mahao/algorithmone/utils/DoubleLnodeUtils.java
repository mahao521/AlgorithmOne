package com.mahao.algorithmone.utils;

import android.util.Log;

import java.security.cert.Certificate;
import java.util.jar.JarEntry;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Penghy on 2017/2/20.
 */


public class DoubleLnodeUtils {

    char data;

    DoubleLnodeUtils next;

    DoubleLnodeUtils prior;


    //创建一个链表 ---- 尾插法
    public static void main(String[] args){

        //打印创建的双向循环链表
       // showLnode(createLnode());


        //向循环链表指定位置插入
/*        DoubleLnodeUtils data = new DoubleLnodeUtils();
        data.data = '0';
        showLnode(insertDoubleLink(createLnode(),data,6));*/


        //向循环链表指定位置删除
        showLnode(deletLink(createLnode(),6));

    }

    //创建一个双向循环链表
    public static DoubleLnodeUtils createLnode(){

        char[] chs = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l'};

        //循环链表
        DoubleLnodeUtils head =  new DoubleLnodeUtils();
        head.next = head;
        head.prior = head;

        DoubleLnodeUtils index = new DoubleLnodeUtils();
        DoubleLnodeUtils data = null;
        index = head;

        int i = 0;
        while(i < chs.length){

            data = new DoubleLnodeUtils();
            data.data = chs[i];
            data.next = head;   //单项设置为null
            data.prior = index;

            head.prior = data;  //将head的头节点指向该节点；

            // 尾插法--索引指向下一个节点，索引加1；
            index.next = data;
            index = data;

            i++;
        }
        return head;
    }


    //打印循环链表
    public static void showLnode(DoubleLnodeUtils head){

        DoubleLnodeUtils start = new DoubleLnodeUtils();

        start = head;
        while(head.next != start){

            head = head.next;
            System.out.print(head.data + "//////");

        }
    }

    //双向链表的插入算法

    /**
     * @param  head  目标的链表
     * @param data   插入的数据源
      * @param i     插入的位置
     */
    public static DoubleLnodeUtils insertDoubleLink(DoubleLnodeUtils head,DoubleLnodeUtils data,int i){

        int j = 0;
        if(j < 0 ){

            System.out.print("插入的位置0-10");
        }else{

            DoubleLnodeUtils lnode = new DoubleLnodeUtils();
            lnode = head;

            //找到这个位置
            while(j < i && lnode.next != head){

                lnode = lnode.next;
                j++;
            }

            //插入操作
            data.next = lnode.next;
            data.prior = lnode;
            lnode.next = data;
        }
        return head;
    }

    //双向循环链表的删除算法
    public static DoubleLnodeUtils deletLink(DoubleLnodeUtils head,int position){


        //需要一个索引，记录我们找到的位置
        DoubleLnodeUtils index = new DoubleLnodeUtils();

        //index指向lnode的数据
        index = head;

        //先找到位于position的位置
        for(int i = 0; i < position; i++){

            index = index.next;
        }

        //删除这个位置的元素
        index.prior.next = index.next;
        index.next.prior = index.prior;
        index = null;

        return head;
    }

}
