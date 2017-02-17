package com.mahao.algorithmone;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.mahao.algorithmone.utils.ALgUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtNum;
    private ArrayList<Integer> mList;
    private TextView mTxtCountNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtNum = (TextView) findViewById(R.id.edt_num);
        mTxtCountNum = (TextView) findViewById(R.id.edt_total_num);
    }

    public void btnClick(View view) {

        int id  = view.getId();
        switch (id){

            case R.id.btn_alg_one: //线性表删除算法

                MyTask task = new MyTask();
                task.execute(mList);

                break;

            case R.id.btn_alg_rand:  // 生成10个随机数

                Random random = new Random();
                mList = new ArrayList<>();
                for(int i = 0; i < 10; i ++){

                    int sub =  random.nextInt(100);
                    mList.add(sub);
                }
                Arrays.sort(mList.toArray());
                mTxtCountNum.setText(mList.toString());
                break;
        }
    }

    public class MyTask extends AsyncTask<List<Integer>,Void,List<Object>>{

        private int number;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

             number = Integer.parseInt(mTxtNum.getText().toString());
             mTxtCountNum.setText(mList.toString());
        }

        @Override
        protected List<Object> doInBackground(List<Integer>... params) {

            List<Integer> param = params[0];
            List<Object> remove = ALgUtils.remove(number,param.toArray());
            return remove;
        }

        @Override
        protected void onPostExecute(List<Object> integers) {
            super.onPostExecute(integers);
            mTxtCountNum.setText(integers.toString());
        }
    }
}
