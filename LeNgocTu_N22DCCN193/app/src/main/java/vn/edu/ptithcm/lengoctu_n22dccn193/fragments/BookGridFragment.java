package vn.edu.ptithcm.lengoctu_n22dccn193.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ptithcm.lengoctu_n22dccn193.R;
import vn.edu.ptithcm.lengoctu_n22dccn193.adapters.BookGridAdapter;
import vn.edu.ptithcm.lengoctu_n22dccn193.models.Book;


public class BookGridFragment extends Fragment {
    private GridView gridView;
    private List<Book> arr;
    private BookGridAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_book_grid, container, false);

        // mapping grid view
        gridView = view.findViewById(R.id.girdView);

        arr = new ArrayList<>();
        adapter = new BookGridAdapter(getContext(), R.layout.book_grid_item, arr);
        gridView.setAdapter(adapter);

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