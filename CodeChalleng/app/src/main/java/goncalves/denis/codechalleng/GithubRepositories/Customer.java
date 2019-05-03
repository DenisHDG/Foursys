package goncalves.denis.codechalleng.GithubRepositories;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Customer {

    @SerializedName("items")
    private List<Item> items;

    public Customer(){

    }

    public Customer(final List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return items.equals(customer.items);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
