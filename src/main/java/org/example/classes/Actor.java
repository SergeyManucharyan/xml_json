package org.example.classes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Painting
 * <p>
 * Painting information
 *
 */
public class Actor {

    /**
     * Painting name
     * (Required)
     *
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * Name of the artist
     * (Required)
     *
     */
    @SerializedName("artist")
    @Expose
    private String artist;
    /**
     * Painting description
     * (Required)
     *
     */
    @SerializedName("description")
    @Expose
    private String description;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("tags")
    @Expose
    private List<Tag> tags;

    /**
     * Painting name
     * (Required)
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Painting name
     * (Required)
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Name of the artist
     * (Required)
     *
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Name of the artist
     * (Required)
     *
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Painting description
     * (Required)
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Painting description
     * (Required)
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * (Required)
     *
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     *
     * (Required)
     *
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}