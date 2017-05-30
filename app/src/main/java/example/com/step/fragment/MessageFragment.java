package example.com.step.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import example.com.step.R;
import example.com.step.activity.DetailMessageActivity;
import example.com.step.activity.DetailNewsActivity;
import example.com.step.adapter.MyMessageAdapter;
import example.com.step.bean.MessageBean;


/**
 * Created by qinghua on 2016/9/4.
 */
public class MessageFragment extends Fragment {

    //private MesageSQliteUtil msgUtil=new MesageSQliteUtil();
    private ListView m_msg_listview;
    private List<MessageBean> msg_listdate;
    private MyMessageAdapter myMessageAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View m_view=inflater.inflate(R.layout.messagefragment,container,false);
        m_msg_listview= (ListView) m_view.findViewById(R.id.message_list);
        return m_view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setData();
        initView();
        initItemClick();
        super.onActivityCreated(savedInstanceState);
    }

    private void initView() {
        myMessageAdapter=new MyMessageAdapter(getContext(),msg_listdate);
        m_msg_listview.setAdapter(myMessageAdapter);
    }

    private void setData() {
        msg_listdate= new ArrayList<MessageBean>();
       // msgUtil.query();
        //msg_listdate.addAll(msgUtil.getMsgList());
        //msg_listdate.add(new MessageBean("咨询小助手","八个动作塑形减肥防疾病 你还不快来","12-20","http://www.lady8844.com/shoushen/ydss/2016-08-05/1470376789d1756751.html"));
        //msg_listdate.add(new MessageBean("咨询小助手","腹部减肥最快方法 七个姿势完美解决赘肉烦恼","12-19","http://www.lady8844.com/shoushen/jbss/2016-06-01/1464770825d1753552.html"));
    }

    private void initItemClick()
    {
        m_msg_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // msgUtil.update(msg_listdate.get(i));
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                msg_listdate.get(i).setmIndex(1);
                final int index=i;
                Intent intent=new Intent();
                intent.setClass(getContext(), DetailMessageActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("messageBean",msg_listdate.get(index));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        m_msg_listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //showPopupWindow(view,i);
                return true;
            }
        });
    }

//
//    private void showPopupWindow(View view,int i) {
//
//        final  int index=i;
//        // 一个自定义的布局，作为显示的内容
//        View contentView = LayoutInflater.from(getContext()).inflate(
//                R.layout.pop_window, null);
//        // 设置按钮的点击事件
//        ImageView tv_delete = (ImageView) contentView.findViewById(R.id.pop_delete);
//
//
//        final PopupWindow popupWindow = new PopupWindow(contentView,
//                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
//
//        popupWindow.setTouchable(true);
//
//        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                Log.i("mengdd", "onTouch : ");
//
//                return false;
//                // 这里如果返回true的话，touch事件将被拦截
//                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
//            }
//        });
//        tv_delete.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                msgUtil.delete(msg_listdate.get(index));
//                msg_listdate.remove(index);
//                myMessageAdapter.notifyDataSetChanged();
//                popupWindow.dismiss();
//            }
//        });
//        //popupWindow.showAsDropDown(view);
//        popupWindow.showAsDropDown(view,view.getWidth()/2,(-view.getHeight())*3/2);
//    }
}
