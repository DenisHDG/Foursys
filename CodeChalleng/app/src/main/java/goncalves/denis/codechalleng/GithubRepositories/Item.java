package goncalves.denis.codechalleng.GithubRepositories;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Item {

    @SerializedName("stargazers_count")
    private int stargazersCount;
    @SerializedName("name")
    private String name;
    @SerializedName("owner")
    private Owner owner;
    public Item(){

    }

    public Item(
            final int stargazersCount,
            final String name,
            final Owner owner) {
        this.stargazersCount = stargazersCount;
        this.name = name;
        this.owner = owner;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(
            final int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return stargazersCount == item.stargazersCount &&
                name.equals(item.name) &&
                owner.equals(item.owner);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(stargazersCount, name, owner);
    }
}