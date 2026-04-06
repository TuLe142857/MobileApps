package vn.edu.ptithcm.lengoctu_n22dccn193.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.ptithcm.lengoctu_n22dccn193.R;
import vn.edu.ptithcm.lengoctu_n22dccn193.models.Book;

public class BookGridAdapter extends BaseAdapter {
    private List<Book> list;
    private int layout;
    private Context context;

    public BookGridAdapter(Context context, int layout, List<Book> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, parent, false);
        }

        Book book = (Book) getItem(position);
        ImageView imgView = convertView.findViewById(R.id.image);
        TextView titleText = convertView.findViewById(R.id.title);
        TextView authorText = convertView.findViewById(R.id.author);
        TextView priceText = convertView.findViewById(R.id.price);

        imgView.setImageResource(book.getImg());
        titleText.setText(book.getTitle());
        authorText.setText(book.getAuthor());
        priceText.setText(String.valueOf(book.getPrice()));
        return convertView;
    }
}
