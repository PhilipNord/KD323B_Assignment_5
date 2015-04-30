package se.k3.antonochisak.kd323bassignment5.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import se.k3.antonochisak.kd323bassignment5.R;
import se.k3.antonochisak.kd323bassignment5.models.movie.Movie;

/**
 * Created by Philip on 2015-04-29.
 */
public class TrendingAdapter extends BaseAdapter{

    ArrayList<Movie> mMovies;
    LayoutInflater mLayoutInfalter;

    public TrendingAdapter(ArrayList<Movie> mMovies, LayoutInflater mLayoutInfalter) {
        this.mMovies = mMovies;
        this.mLayoutInfalter = mLayoutInfalter;
    }

    class ViewHolder{

        @InjectView(R.id.movie_poster)
        ImageView poster;

        @InjectView(R.id.movie_title)
        TextView title;

        @InjectView(R.id.movie_year)
        TextView year;


        public ViewHolder(View view) {
            ButterKnife.inject(this, view);

        }


    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = mLayoutInfalter.inflate(R.layout.trending_list_items, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else{
            holder = (ViewHolder) view.getTag();
        }

        Movie m = mMovies.get(i);

        String title = String.valueOf(m.getTitle());
        holder.title.setText(title);

        String year = String.valueOf(m.getYear());
        holder.year.setText(year);


        Picasso.with(view.getContext()).load(mMovies.get(i).getPoster()).into(holder.poster);


        return view;
    }


    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
