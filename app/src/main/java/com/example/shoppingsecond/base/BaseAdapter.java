package com.example.shoppingsecond.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    protected Context context;
    public List<T> mData;
    private IClick callback;
    private View view;


    public void setCallback(IClick callback) {
        this.callback = callback;
    }

//    public BaseAdapter(ArrayList<HotDrowBean.DataBean> context, Fragment_find mData) {
//        this.context = context;
//        this.mData = mData;
//    }

    public BaseAdapter(Context context, List<T> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLayout(), null);
        final BaseViewHolder vh = new BaseViewHolder(view);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) {
                    callback.click(vh.getAdapterPosition());
                }
            }
        });
        return vh;
    }

    protected abstract int getLayout();

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder vh = (BaseViewHolder) holder;
        T _data = mData.get(position);
        bindData(vh, _data,position);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    /*
     * 获取当前适配器布局Layout
     * @return
     * */
    protected abstract void bindData(BaseViewHolder vh, T data, int position);

    public interface IClick {
        void click(int pos);
    }

    /*
     * 基类适配器
     * */
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        SparseArray views = new SparseArray();

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        /*
         * 通过ID获取适配器组件
         * @param id
         * @return
         * */
        public View getViewById(int id) {
            View view = (View) views.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                views.append(id, view);
            }
            return view;
        }
    }


}
