package com.yey;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.yey.databinding.ActivityYImageSelectTvBinding;
import com.yey.vm.YImageSelectTextViewVM;
import com.yey.ycustomeview.YImageSelectTextView;
import com.yey.ycustomeview.YSelectTextView;

public class YImageSelectTextViewActivity extends AppCompatActivity {
    ActivityYImageSelectTvBinding binding;
    YImageSelectTextViewVM mVM;
    private String TAG = "YButtomSelectViewActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = (ActivityYImageSelectTvBinding) DataBindingUtil.setContentView(this, R.layout.activity_y_image_select_tv);
        setContentView(binding.getRoot());
        // MutableLiveData 双向绑定
        mVM = new ViewModelProvider(this).get(YImageSelectTextViewVM.class);
        binding.setMVM(mVM);


        binding.ybsv1.setClickFocuseListener(new YImageSelectTextView.IClickFocuse() {

            @Override
            public void onClick(YImageSelectTextView yButtomSelectView) {
                Log.e(TAG, "点击获取的回调" );
            }

            @Override
            public void getFocuse(int count, YImageSelectTextView yButtomSelectView) {
                Log.e(TAG, "获取焦点时获取的回调" );
            }
        });

        binding.btnRequestFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ybsv1.requestFocus();
            }
        });

        binding.btnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ybshav3.setContent("QWEQWERTYUIOP{ASDFGHJKLZXCVBNM<WERTYUIOPSDFGHJKLSDFGHJKLSDFGHJKLQWEQWERTYUIOP{ASDFGHJKLZXCVBNM<WERTYUIOPSDFGHJKLSDFGHJKLSDFGHJKLQWEQWERTYUIOP{ASDFGHJKLZXCVBNM<WERTYUIOPSDFGHJKLSDFGHJKLSDFGHJKL水门");
            }
        });
        binding.btnClearContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ybsv1.clearContent();
            }
        });
        binding.btnShowErr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ybsv1.setErr("错误");
            }
        });
        binding.btnHideErr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ybsv1.clearErr();
            }
        });
        // 打印数据
        binding.btnPrintData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(YImageSelectTextViewActivity.this, mVM.mChangeContent.get(), Toast.LENGTH_LONG).show();
            }
        });
    }
}