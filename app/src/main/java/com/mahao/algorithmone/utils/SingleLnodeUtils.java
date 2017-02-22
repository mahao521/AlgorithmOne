package com.mahao.algorithmone.utils;

import java.util.Scanner;

/**
 * Created by Penghy on 2017/2/17.
 */

public class SingleLnodeUtils {


    public int data;

    public SingleLnodeUtils next;    //SingleLnodeUtils 为节点类型

    //头插法
    public static SingleLnodeUtils headInsert(){

        char ch ;  //获取数据
        SingleLnodeUtils node  = null;

        //建立头结点
        SingleLnodeUtils head = new SingleLnodeUtils();
        head.next = null;

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i = 0;

        while (i < str.length()){

            ch = str.charAt(i);
            node = new SingleLnodeUtils();
            node.data = ch;
            node.next = head.next;
            head.next = node;
            i++;
        }

        return node;
    }

    //尾插法
    public static SingleLnodeUtils footInsert(){

        SingleLnodeUtils node,index;
        SingleLnodeUtils head = new SingleLnodeUtils();

        index = head;
        head.next = null;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int i = 0;
        while(i < str.length()){

            char ch = str.charAt(i);
            node = new SingleLnodeUtils();
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
      //  setNode(deleteElement(3));

        //逆置一个链表
       //   setNode(reverseLink(createLnode()));

        //合并两个有序的链表
        setNode(collectLink(createLnode(false),createLnode(true)));

    }

    //遍历整个node
    public static void setNode(SingleLnodeUtils node){

        while(node !=null &&node.next != null){

            System.out.print(node.data+"...");
            node = node.next;
        }
        System.out.println(node.data+"...");
    }

        //在单链表的第I个元素之前插入一个元素的算法
      public  static SingleLnodeUtils insertElement(int i, char x){

          SingleLnodeUtils p,s;
          char[] chs = new char[]{'a','b','c','d','e','f','g','h','i','j','k','m','n'};
          //生成一个链表
          s = new SingleLnodeUtils();
         for(int j = 0; j < 11; j++){

             p = new SingleLnodeUtils();
             p.data = chs[j];
             p.next = s.next;
             s.next = p;

         }
        //  setNode(s);

          //声明一个index; 指向i-1；
          SingleLnodeUtils index = new SingleLnodeUtils();

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
    public static SingleLnodeUtils deleteElement(int i){


        //生成一个链表 ----尾插法
        char[] chs  = new char[]{'1','2','3','4','5','6','7','8','9','a','d','c','d'};

        SingleLnodeUtils index = new SingleLnodeUtils();
        SingleLnodeUtils data;
        SingleLnodeUtils head = new SingleLnodeUtils();
        index = head;
        int j = 0;

        //创建一个链表
        while(j < chs.length){

            data = new SingleLnodeUtils();
            data.data = chs[j];
            data.next = null;
            index.next = data;  // index 代表head;'
            index = data;
            j++;
        }

          setNode(head);

        SingleLnodeUtils removeIndex = new SingleLnodeUtils();
        removeIndex = head;

        //指定位置的P
        for(int z = 0; z < i ; z++){

            removeIndex = removeIndex.next;

            if(z == i-1){

               SingleLnodeUtils temp  = new SingleLnodeUtils();
               temp = removeIndex.next;
                removeIndex.next = temp.next;
                temp = null;
            }
        }
        return head;

    }


    //单链表的逆置
    public static SingleLnodeUtils  reverseLink(SingleLnodeUtils head){

        //理论：将头结点的指针在最后修改成指向原表的最后一个节点，即就是新表的第一个节点
        SingleLnodeUtils index = new SingleLnodeUtils();

        index = head.next;  //第一个节点
        if(index == null){  //链表为空

            return null;

        }else if(index.next ==  null){ //链表上只有一个节点，不需要反序

            return head;
        }

        SingleLnodeUtils single = index;

        index = index.next; //为了获取下一个位置的起点
        setNode(index);

        single.next = null;   //第一个节点的指针域为null

        setNode(index);

        while(index != null){

            System.out.print("mahao");
            //将index后面的数据头插法single后面
            SingleLnodeUtils data = index.next;  //获取数据源

            index.next = single;  //利用第一个节点插入
            single = index;

            index = data;  //也循环遍历了，但是没有改变index的位置

        }
        head.next = single;
        return head;
    }


    //创建一个链表！
    public static SingleLnodeUtils createLnode(boolean flag){

        //生成一个链表 ----尾插法
        int[] chs;
        if(flag == true){

            chs = new int[]{1,2,4,6,8,11,25,45};

        }else {

            chs  = new int[]{2,3,34};
        }
        SingleLnodeUtils index = new SingleLnodeUtils();
        SingleLnodeUtils data;
        SingleLnodeUtils head = new SingleLnodeUtils();
        head.next = null;
        index = head;

        setNode(head);
        int j = 0;

        //创建一个链表
        while(j < chs.length){

            data = new SingleLnodeUtils();
            data.data = chs[j];
            data.next = null;
            index.next = data;  // index 代表head;'
            index = data;
            j++;
        }
        setNode(head);
        return head.next;    //链表包含了一个头节点
    }

    //顺序链表的归并算法
    //算法： 2个有序的链表； 合成一个有序的链表
    public static SingleLnodeUtils collectLink(SingleLnodeUtils one,SingleLnodeUtils two){

        SingleLnodeUtils target = new SingleLnodeUtils();
        SingleLnodeUtils index = new SingleLnodeUtils();

        index = target; //去除首节点

        SingleLnodeUtils data ;
        while(one != null && two != null){

            data = new SingleLnodeUtils();
            if(one.data < two.data){

                data = one;
                one = one.next;

            }else {

                data  = two;
                two = two.next;
            }
            index.next = data;
            index = data;
        }

        //判断one链表的其他数据
        while(one != null){

            one = one.next;
            index.next = one;
            index = one;
        }

        //判断two链表的其他数据
        while(two != null){

            two = two.next;
            index.next = two;
            index = two;
        }
        return target.next;  // 链表包含了一个头节点
    }
}





















