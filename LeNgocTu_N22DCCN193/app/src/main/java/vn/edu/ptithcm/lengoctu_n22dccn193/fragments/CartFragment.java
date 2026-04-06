package vn.edu.ptithcm.lengoctu_n22dccn193.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ptithcm.lengoctu_n22dccn193.R;
import vn.edu.ptithcm.lengoctu_n22dccn193.adapters.CardListAdapter;
import vn.edu.ptithcm.lengoctu_n22dccn193.models.Book;

public class CartFragment extends Fragment {
    List<Book> arr;
    ListView listView;
    CardListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_cart, container, false);

        listView = view.findViewById(R.id.listView);

        arr = new ArrayList<>();
        adapter = new CardListAdapter(getContext(), R.layout.book_cart_item, arr);
        listView.setAdapter(adapter);

        arr.add(
                new Book("title 1", "author 1", R.drawable.book1, 100.01)
        );

        arr.add(
                new Book("title 2", "author 2", R.drawable.book2, 200.01)
        );

        arr.add(
                new Book("title 3", "author 3", R.drawable.book3, 300.01)
        );

        arr.add(
                new Book("title 4", "author 4", R.drawable.book4, 400.01)
        );

        arr.add(
                new Book("title 5", "author 5", R.drawable.book5, 500.01)
        );

        arr.add(
                new Book("title 6", "author 6", R.drawable.book6, 600.01)
        );
        adapter.notifyDataSetChanged();

        return view;
    }
}