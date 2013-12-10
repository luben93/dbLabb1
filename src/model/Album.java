package model;

import java.util.ArrayList;

public class Album {
	private String[] artist;
	private String album, genre, rating, review;

	public Album() {
		System.out.println("just smile and wave boys :)");
	}

	public Album(String[] artist, String album, String genre, String rating,
			String review) {
		this.album = album;
		this.artist = artist;
		this.genre = genre;
		this.rating = rating;
		this.review = review;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setArtis(String[] artist) {
		this.artist = artist;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAlbum() {
		return album;
	}

	public String[] getArtist() {
		return artist;
	}

	public String getGenre() {
		return genre;
	}

	public String getRating() {
		return rating;
	}

	public String getreview() {
		return review;
	}

	public String toString() {
		String out = null;
		out = album + " ";
		for (int i = 0; i < artist.length; i++) {
			out = out + artist[i] + " ";
		}
		out = out + genre + " " + rating + " " + review;
		return out;
	}

	public String[][] getArray() {
		String[][] temp = new String[10][];
		temp[0][0]= album;
		temp[1]=artist;
		temp[2][0]=genre;
		temp[3][0]=rating;
		temp[4][0]=review;

		return temp;
	}

}
