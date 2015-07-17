package com.taha.testprovider;

import android.net.Uri;
import android.provider.BaseColumns;

public class BookProviderMetaData {

	public static final String AUTHORITY = "com.androidbook.provider.BookProvider";

	public static final String DATABASE_NAME = "book.db";
	public static final int DATABASE_VERSION = 1;
	public static final String BOOK_TABLE_NAME = "book";

	private BookProviderMetaData() {
		// TODO Auto-generated constructor stub
	}

	// inner class describing BookTable

	public static final class BookTableMetaData implements BaseColumns {

		private BookTableMetaData() {
			// TODO Auto-generated constructor stub
		}

		public static final String TABLE_NAME = " books";

		// uri and MIME type definitions

		public static final Uri CONTENT_URI = Uri.parse("content://"
				+ AUTHORITY + "/books");

		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.androidbook.book";

		public static final String CONTENT_ITEN_TYPE = "vnd.android.cursor.item/vnd.androidbook.book";
		
		public static final String DEFAULT_SORT_ORDER = "modified DESC";
		
		//Additional Columns start here.
		//string type
		public static final String BOOK_NAME = "name";
		//string type
		public static final String BOOK_ISBN = "isbn";
		//string type
		public static final String BOOK_AUTHOR = "author";
		
		//Integer from System.currentTimeMillis()
		public static final String CREATED_DATE = "created";
		
		//Integer from System.currentTimeMillis()
		public static final String MODIFIED_DATE = "modified";

	}
}
