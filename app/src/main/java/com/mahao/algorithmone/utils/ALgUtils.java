package com.mahao.algorithmone.utils;

import android.util.Log;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Penghy on 2017/2/17.
 */


public class ALgUtils {

    //删除元素的序列号，删除元素的值返回

    /**
     *
     * @param i  删除第i个元素
     * @param arr
     * @return
     */
    public static  List<Object> remove(int i, Object[] arr){



        if(i < 1 || i > arr.length){

            System.out.print("删除的元素不正确");
            return null;

        }else {

            //删除之后，所有的位置的元素向前移动一个位置
            for(int j = i; j < arr.length;  j++){

                arr[j-1] = arr[j];
            }
            Log.i("mahao", Arrays.toString(arr));

            List<Object> objects = Arrays.asList(arr);
            return objects;
        }
    }





}
