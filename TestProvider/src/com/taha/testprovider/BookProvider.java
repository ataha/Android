package com.taha.testprovider;

import java.util.HashMap;

import com.taha.testprovider.BookProviderMetaData.BookTableMetaData;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class BookProvider extends ContentProvider {

	// Logging helper tag. No significance to providers.
	private static final String TAG = "BookProviders";

	// Setup projection Map
	// Projection maps are similar to "as" (column alias) construct
	// in an sql statement where by you can rename the
	// columns.

	private static HashMap<String, String> sBooksProjectionMap;

	static {
		sBooksProjectionMap = new HashMap<String, String>();
		sBooksProjectionMap.put(BookTableMetaData._ID, BookTableMetaData._ID);
		// name, isbn, author
		sBooksProjectionMap.put(BookTableMetaData.BOOK_NAME,
				BookTableMetaData.BOOK_NAME);
		sBooksProjectionMap.put(BookTableMetaData.BOOK_ISBN,
				BookTableMetaData.BOOK_ISBN);
		sBooksProjectionMap.put(BookTableMetaData.BOOK_AUTHOR,
				BookTableMetaData.BOOK_AUTHOR);
		// created date, modified date
		sBooksProjectionMap.put(BookTableMetaData.CREATED_DATE,
				BookTableMetaData.CREATED_DATE);
		sBooksProjectionMap.put(BookTableMetaData.MODIFIED_DATE,
				BookTableMetaData.MODIFIED_DATE);
	}

	// Setup URIs
	// Provide a mechanism to identify
	// all the incoming uri patterns.

	private static final UriMatcher sUriMatcher;
	private static final int INCOMING_BOOK_COLLECTION_URI_INDICATOR = 1;
	private static final int INCOMING_SINGLE_BOOK_URI_INDICATOR = 2;

	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(BookProviderMetaData.AUTHORITY, "book",
				INCOMING_BOOK_COLLECTION_URI_INDICATOR);
		sUriMatcher.addURI(BookProviderMetaData.AUTHORITY, "book/#",
				INCOMING_SINGLE_BOOK_URI_INDICATOR);
	}

	/**
	 * Setup/Create Database This class helps open, create, and upgrade the
	 * database file.
	 */

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {

			// TODO Auto-generated constructor stub
			super(context, BookProviderMetaData.DATABASE_NAME, null,
					BookProviderMetaData.DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			Log.d(TAG, "inner oncreate called");
			db.execSQL("CREATE TABLE " + BookTableMetaData.TABLE_NAME + " ( "
					+ BookTableMetaData._ID + " INTEGER PRIMARY KEY, "
					+ BookTableMetaData.BOOK_NAME + " TEXT, "
					+ BookTableMetaData.BOOK_ISBN + " TEXT, "
					+ BookTableMetaData.BOOK_AUTHOR + " TEXT, "
					+ BookTableMetaData.CREATED_DATE + " INTEGER, "
					+ BookTableMetaData.MODIFIED_DATE + " INTEGER, " + ");");

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
