package com.example.hp.blogapp.Activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.blogapp.Activities.model.Blog;
import com.example.hp.blogapp.Activities.model.Notification;
import com.example.hp.blogapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 6/28/2018.
 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.MyViewHolder> implements Filterable {

    private List<Blog> blogList = new ArrayList<>();
    private Context context;
    private List<Blog> blogListFiltered = new ArrayList<>();
    private BlogFilterListener listener;

    public NewsFeedAdapter(List<Blog> blogList, Context context, BlogFilterListener listener) {
        this.blogList = blogList;
        this.context = context;
        this.listener = listener;
        this.blogListFiltered = blogList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_item, parent, false);
        return new NewsFeedAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Blog blog = blogList.get(holder.getAdapterPosition());

        holder.caption.setText(blog.getBlogCaption());
        holder.userName.setText(blog.getUserName());
        holder.postedDate.setText(blog.getDate());
        holder.commentsCount.setText(blog.getComments());
        holder.likesCount.setText(blog.getLikes());
        Picasso.get().load(blog.getBlogImageUrl()).into(holder.blogImage);
        Picasso.get().load(blog.getUserImageUrl()).into(holder.thumbNail);


    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    blogListFiltered = blogList;
                } else {
                    List<Blog> filteredList = new ArrayList<>();
                    for (Blog row : blogList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getBlogCaption().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    blogListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = blogListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                blogListFiltered = (ArrayList<Blog>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView userName;
        public TextView postedDate;
        public TextView caption;
        public TextView likesCount;
        public TextView commentsCount;
        public ImageView thumbNail;
        public ImageView blogImage;
        public View view;


        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            userName = view.findViewById(R.id.user_name);
            postedDate = view.findViewById(R.id.date);
            caption = view.findViewById(R.id.blog_caption);
            likesCount = view.findViewById(R.id.likes_count);
            commentsCount = view.findViewById(R.id.comment_count);
            thumbNail = view.findViewById(R.id.cicrle_image_view);
            blogImage = view.findViewById(R.id.imageView2);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onBlogFiltered(blogListFiltered.get(getAdapterPosition()));
                }
            });
        }

    }

    public interface BlogFilterListener {
        void onBlogFiltered(Blog blog);
    }

}
