package com.example.librarymanager;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder> {

    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;

    public BooksRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtName.setText(books.get(position).getName());
        Glide.with(mContext).asBitmap().load(books.get(position).getImageUrl()).into(holder.imgBook);

        holder.parent.setOnClickListener(
                (view -> Toast.makeText(mContext, books.get(position).getName() + " selected", Toast.LENGTH_SHORT).show()));

        holder.author.setText(books.get(position).getAuthor());
        holder.descrip.setText(books.get(position).getShortDescription());

        if (books.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }
        else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;

        private Book book;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedLayout;
        private TextView author, descrip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.bookImg);
            txtName = itemView.findViewById(R.id.txtBookName);

            book = books.get(getAdapterPosition());

            downArrow = itemView.findViewById(R.id.expandCardArrowImg);
            upArrow = itemView.findViewById(R.id.retractCardArrowImg);
            expandedLayout = itemView.findViewById(R.id.expendedRelLayout);
            author = itemView.findViewById(R.id.authorName);
            descrip = itemView.findViewById(R.id.shortDescription);

            downArrow.setOnClickListener(view -> {
                book.toggleExpended();
                notifyItemChanged(getAdapterPosition());
            });

            upArrow.setOnClickListener(view -> {
                book.toggleExpended();
                notifyItemChanged(getAdapterPosition());
            });

//            downArrow.setOnClickListener(view -> {
//                book.expand();
//                expandedLayout.setVisibility(View.VISIBLE);
//                downArrow.setVisibility(View.INVISIBLE);
//                notifyItemChanged(getAdapterPosition());
//            });
//
//            upArrow.setOnClickListener(view -> {
//                book.retract();
//                expandedLayout.setVisibility(View.GONE);
//                downArrow.setVisibility(View.VISIBLE);
//                notifyItemChanged(getAdapterPosition());
//            });
        }
    }
}
