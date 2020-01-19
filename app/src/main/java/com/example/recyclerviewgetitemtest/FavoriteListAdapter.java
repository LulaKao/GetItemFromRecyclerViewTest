package com.example.recyclerviewgetitemtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.ViewHoler> {
    private Context context;
    private ArrayList<FavoriteModel> favoriteList;
    private boolean isVisible; // 刪除的 button 是否顯示（預設是 false）
    private ImageButton btn_delete;

    public FavoriteListAdapter(Context context,ArrayList<FavoriteModel> favoriteList) {
        this.context = context;
        this.favoriteList = favoriteList;
    }

    @NonNull
    @Override
    public FavoriteListAdapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_list,null);
        ViewHoler viewHoler = new ViewHoler(view);
        return viewHoler;
    }

    public class ViewHoler extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Button video_name;
        private ImageButton video_image;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            video_name = itemView.findViewById(R.id.favoritepageVideoName);
            video_image = itemView.findViewById(R.id.favoritepageVideoImg);
            btn_delete = itemView.findViewById(R.id.favoritepageDelete);

            // 設定刪除的點擊事件
            btn_delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                // 刪除最愛
                case R.id.favoritepageDelete:
                    Toast.makeText(v.getContext(),"刪除項目"+favoriteList.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListAdapter.ViewHoler holder, int position) {
        holder.video_image.setImageResource(favoriteList.get(position).getVideo_img());
        holder.video_name.setText(favoriteList.get(position).getVideo_name());
    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    // 改變刪除按鈕的可視狀態
    public void changeDeleteButtonStatus(boolean isVisible) {
        this.isVisible = isVisible;
        //notifyDataSetChanged();

        if(isVisible) {
            btn_delete.setVisibility(View.VISIBLE);
        }else {
            btn_delete.setVisibility(View.GONE);
        }
    }
}
