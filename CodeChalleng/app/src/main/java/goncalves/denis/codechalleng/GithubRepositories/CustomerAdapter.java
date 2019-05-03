package goncalves.denis.codechalleng.GithubRepositories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import goncalves.denis.codechalleng.R;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomViewHolder> {

    private Customer dataList;
    private Context context;

    public CustomerAdapter(
            final Context context,
            final Customer dataList) {

        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private final View view;
        private TextView textViewName;
        private TextView textViewLoginName;
        private TextView textViewStars;
        private ImageView coverImage;


        CustomViewHolder(final View itemView) {
            super(itemView);
            view = itemView;

            textViewName = view.findViewById(R.id.textViewName);
            textViewLoginName = view.findViewById(R.id.textViewLoginName);
            textViewStars = view.findViewById(R.id.textViewStars);
            coverImage = view.findViewById(R.id.imageViewAvatarPhoto);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(
            @NonNull final ViewGroup parent,
            final int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(
                R.layout.custom_row,
                parent,
                false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull final CustomViewHolder holder,
            final int position) {

        holder.textViewName.setText(
                dataList.getItems()
                        .get(position)
                        .getName());

        holder.textViewLoginName.setText(
                dataList.getItems()
                        .get(position)
                        .getOwner()
                        .getLoginName());

        holder.textViewStars.setText(String.valueOf(
                dataList.getItems()
                        .get(position)
                        .getStargazersCount()));

        Picasso
                .with(context.getApplicationContext())
                .load(dataList.getItems()
                        .get(position)
                        .getOwner()
                        .getAvatarUrl())
                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.getItems().size();
    }
}