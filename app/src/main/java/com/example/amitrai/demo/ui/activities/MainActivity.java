package com.example.amitrai.demo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amitrai.demo.R;
import com.example.amitrai.demo.ui.adapters.MessageAdapter;
import com.example.amitrai.demo.ui.modals.MessageModal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycle_message)
    RecyclerView recycle_message;


    @Bind(R.id.edt_message)
    EditText edt_message;

    List<MessageModal> list_messages = new ArrayList<>();
    MessageAdapter adapter = null;
    RecyclerView.LayoutManager manager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


    private void initView(){
        list_messages.clear();
        manager = new LinearLayoutManager(this);
        adapter = new MessageAdapter(list_messages);
        recycle_message.setLayoutManager(manager);
        recycle_message.setAdapter(adapter);
    }

    @OnClick(R.id.btn_send)
    void sendMessage(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            String formattedDate = sdf.format(c.getTime());
            Date current_date = sdf.parse(formattedDate);
            String message =edt_message.getText().toString();
            if(!message.isEmpty()){
                list_messages.add(new MessageModal(message, current_date));
                edt_message.setText("");
                adapter.notifyDataSetChanged();
                manager.scrollToPosition(list_messages.size() -1);
            }else {
                Toast.makeText(MainActivity.this, R.string.empty_msg, Toast.LENGTH_SHORT).show();
            }

        }catch (Exception exp){
            exp.printStackTrace();
        }


    }
}
