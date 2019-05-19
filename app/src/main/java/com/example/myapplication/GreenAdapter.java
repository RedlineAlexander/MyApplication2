package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder>{


    private static final  String TAG = GreenAdapter.class.getSimpleName();
    private  final ListItemClickListener mOnClickListener;
    private  static int viewHolderCount;
    private int mNumberItems;

public  interface ListItemClickListener{

    void onListItemClick(int clickedItemIndex);

    }

public GreenAdapter(int mNumberOfItems, ListItemClickListener listener){
    mNumberItems = mNumberOfItems;
    mOnClickListener = listener;
    viewHolderCount = 0;
}

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);




    return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
       Log.d(TAG, "#" +position);
       holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }


    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
TextView listItemNumberView;
TextView viewHolderIndex;



        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_item_number);
            viewHolderIndex = (TextView) itemView.findViewById(R.id.tv_view_holder_instance);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex){listItemNumberView.setText(String.valueOf(listIndex));}

        @Override
        public void onClick(View view){
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }

}
