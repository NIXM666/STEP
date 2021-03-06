package example.com.step.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import example.com.step.R;
import example.com.step.bean.MessageBean;
import example.com.step.widget.CircleImageView;

/**
 * Created by qinghua on 2016/11/19.
 */

public class MyMessageAdapter extends BaseAdapter {
    private List<MessageBean> mylist;
    private LayoutInflater inflater;
    public MyMessageAdapter(Context context,List<MessageBean> list)
    {
        mylist=list;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return mylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHold viewHold=null;
        if(view==null)
        {
            viewHold=new ViewHold();
            view=inflater.inflate(R.layout.mymessage_item,null);
            viewHold.circleImageView= (CircleImageView) view.findViewById(R.id.img_cic_head);
            viewHold.tv_name= (TextView) view.findViewById(R.id.tv_nicheng);
            viewHold.tv_context= (TextView) view.findViewById(R.id.tv_msg_context);
            viewHold.tv_msg_time= (TextView) view.findViewById(R.id.msg_date);
            view.setTag(viewHold);
        }
        else
        {
            viewHold= (ViewHold) view.getTag();

        }
        //viewHold.circleImageView.setImageResource(mylist.get(i).getHead_img_id());
        viewHold.tv_name.setText(mylist.get(i).getM_name());
        viewHold.tv_context.setText(mylist.get(i).getM_content());
        viewHold.tv_msg_time.setText(mylist.get(i).getMsg_date());
        if(mylist.get(i).getmIndex()==0)
        {
            view.setBackgroundColor(Color.parseColor("#FFC0CB"));
            view.getBackground().setAlpha(100);
        }
        return view;
    }

    class ViewHold
    {
        public CircleImageView circleImageView;
        public TextView tv_name,tv_context,tv_msg_time;
    }
}
