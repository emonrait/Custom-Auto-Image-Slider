package com.example.customautoimageslider;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.show_image);

        SliderView sliderView = findViewById(R.id.imageSlider);
        // we are creating array list for storing our image urls.
        ArrayList<SliderItem> sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new SliderItem("https://3.bp.blogspot.com/-Wxr9iElgMHc/XvEleXaZOTI/AAAAAAAAAQY/WcZotaCBqdYQzBX5HBjTr1R3NkiKtS1sgCLcBGAsYHQ/s1600/lion.png", "The animal population decreased by 58 percent in 42 years."));
        sliderDataArrayList.add(new SliderItem("https://3.bp.blogspot.com/-Wxr9iElgMHc/XvEleXaZOTI/AAAAAAAAAQY/WcZotaCBqdYQzBX5HBjTr1R3NkiKtS1sgCLcBGAsYHQ/s1600/lion.png", "The animal population decreased by 58 percent in 42 years."));
        sliderDataArrayList.add(new SliderItem("https://3.bp.blogspot.com/-Wxr9iElgMHc/XvEleXaZOTI/AAAAAAAAAQY/WcZotaCBqdYQzBX5HBjTr1R3NkiKtS1sgCLcBGAsYHQ/s1600/lion.png", "The animal population decreased by 58 percent in 42 years."));
        sliderDataArrayList.add(new SliderItem("https://3.bp.blogspot.com/-Wxr9iElgMHc/XvEleXaZOTI/AAAAAAAAAQY/WcZotaCBqdYQzBX5HBjTr1R3NkiKtS1sgCLcBGAsYHQ/s1600/lion.png", "The animal population decreased by 58 percent in 42 years."));


        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList, new SliderAdapter.OnItemClickListener() {
            @Override
            public void onContactSelected(SliderItem item) {
                Toast.makeText(getApplicationContext(), item.getDescription().toString(), Toast.LENGTH_SHORT).show();
                Glide.with(imageView)
                        .load(item.getImageUrl())
                        .fitCenter()
                        .into(imageView);

            }
        });

        // adapter.addItem(new SliderItem("https://3.bp.blogspot.com/-Wxr9iElgMHc/XvEleXaZOTI/AAAAAAAAAQY/WcZotaCBqdYQzBX5HBjTr1R3NkiKtS1sgCLcBGAsYHQ/s1600/lion.png", "The animal population decreased by 58 percent in 42 years."));
        // adapter.addItem(new SliderItem("https://4.bp.blogspot.com/-8U-yeWQyT-g/XvEld2GJKQI/AAAAAAAAAQU/EaqkAB8h8g0kDDDowQ3-2MxvHU1R7S6_QCLcBGAsYHQ/s1600/hands.jpg", "The animal population decreased by 58 percent in 42 years."));
        // adapter.addItem(new SliderItem("https://3.bp.blogspot.com/-B9_SO1pZJTw/XvElYpggK0I/AAAAAAAAAQQ/ZKP7yjF-IOAnukbbt-4LfvXk99ekuGGbQCLcBGAsYHQ/s1600/elephant.jpg", "The animal population decreased by 58 percent in 42 years."));
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(2); //set scroll delay in seconds :
        sliderView.startAutoCycle();


    }
}
