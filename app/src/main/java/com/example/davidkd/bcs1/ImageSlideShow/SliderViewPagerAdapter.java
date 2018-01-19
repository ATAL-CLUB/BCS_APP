package com.example.davidkd.bcs1.ImageSlideShow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.davidkd.bcs1.R;

import java.util.List;

/**
 * Created by davidkd on 09/03/2017.
 */

public class SliderViewPagerAdapter extends PagerAdapter implements View.OnClickListener {
    Context context;
    List<String> list;
    LayoutInflater inflater;


    public SliderViewPagerAdapter(Context paramContext, List<String> paramArrayList) {
        this.context = paramContext;
        this.list = paramArrayList;
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        ((ViewPager) paramViewGroup).removeView((LinearLayout) paramObject);

    }


    public int getCount() {
        return this.list.size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        this.inflater = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View localView = this.inflater.inflate(R.layout.image_viewpager_item, paramViewGroup, false);
        ImageView localImageView = (ImageView) localView.findViewById(R.id.image);

        localImageView.setTag(paramInt);
        ((ViewPager) paramViewGroup).addView(localView);

        if(list.get(paramInt).equalsIgnoreCase("img1")){

            localImageView.setImageResource(R.drawable.slide_pic1);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img2")){

            localImageView.setImageResource(R.drawable.pic2_slide);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img3")){

            localImageView.setImageResource(R.drawable.slide_pic3);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img4")){

            localImageView.setImageResource(R.drawable.slide_pic4);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img5")){

            localImageView.setImageResource(R.drawable.slide_pic5);
        }

        else if(list.get(paramInt).equalsIgnoreCase("img6")){

            localImageView.setImageResource(R.drawable.slide_pic6);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img7")){

            localImageView.setImageResource(R.drawable.slide_pic7);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img8")){

            localImageView.setImageResource(R.drawable.slide_pic8);
        }
        else if(list.get(paramInt).equalsIgnoreCase("img9")){

            localImageView.setImageResource(R.drawable.slide_pic9);
        }

        localImageView.setOnClickListener(this);

        return localView;


    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();

     //   Toast.makeText(context,"Clicked on image" + position,Toast.LENGTH_SHORT).show();

        if(position == 0 ){
            goToURL("http://www.bcs.org/", v);

        } else if (position == 1){
            goToURL("http://shop.bcs.org/display.asp?K=9781780173221#", v);

        }else {
            goToURL("http://www.bcs.org/category/18775", v);//*/

        }

        /*switch (position){
            case 0:
                goToURL("http://www.bcs.org/", v);
            case 1:
                goToURL("http://shop.bcs.org/display.asp?K=9781780173221#", v);//3
            case 2:
                goToURL("http://www.bcs.org/category/19022?src=hs1", v);//
            case 3:
                goToURL("http://twitter.com/bcs?lang=en", v);//
            case 4:
                goToURL("http://www.bcs.org/category/5779", v);//
            case 5:
                goToURL("http://www.bcs.org/category/5653", v);//
            case 6:
                goToURL("https://twitter.com/bcs?lang=en", v);//
            case 7:
                goToURL("https://twitter.com/Edu_BCS", v);//
            case 8:
                goToURL("http://www.bcs.org/category/18775", v);//*/

          //      break;
      //  }


    }

    public void goToURL(String url, View v) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        Intent chooser = Intent.createChooser(intent, "Choose an application...");
        v.getContext().startActivity(chooser);
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        boolean bool;
        if (paramView != (LinearLayout) paramObject)
            bool = false;
        else
            bool = true;
        return bool;
        //return view.equals(object);
    }

}
