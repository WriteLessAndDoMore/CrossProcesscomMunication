// IBookManager.aidl
package com.android.myserviceapp;
import com.android.myserviceapp.BookAidl;
// Declare any non-default types here with import statements

interface IBookManager {
    List<BookAidl> getBookList();
    void addBook(in BookAidl book);
}