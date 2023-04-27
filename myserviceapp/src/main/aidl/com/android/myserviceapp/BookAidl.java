package com.android.myserviceapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @description:
 * @Author: dongxiangyang
 * @Date: 2023/4/26 上午11:38
 */
public class BookAidl implements Parcelable {
    public int bookId;

    public String bookName;

    public BookAidl(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public static final Creator<BookAidl> CREATOR = new Creator<BookAidl>() {
        @Override
        public BookAidl createFromParcel(Parcel in) {
            return new BookAidl(in);
        }

        @Override
        public BookAidl[] newArray(int size) {
            return new BookAidl[size];
        }
    };

    protected BookAidl(Parcel in) {
        this.bookId = in.readInt();
        this.bookName = in.readString();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookAidl{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(bookId);
        parcel.writeString(bookName);
    }
}
