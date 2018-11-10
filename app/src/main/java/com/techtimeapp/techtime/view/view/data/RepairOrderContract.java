package com.techtimeapp.techtime.view.view.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import com.techtimeapp.techtime.view.view.data.RepairOrder;


public final class RepairOrderContract {


    private RepairOrderContract(){}


    public static final String CONTENT_AUTHORITY = "com.example.android.techtime";


    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final String PATH_REPAIR_ORDERS = "repair orders";

    public static final class RepairOrderEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_REPAIR_ORDERS);

        // Table Name
        public static final String TABLE_NAME = "RepairOrder";

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REPAIR_ORDERS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single repair order.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REPAIR_ORDERS;

        //base column for database to uniquely identify ROS
        public static final String _ID = BaseColumns._ID;

        //Column names
        public static final String COLUMN_REPAIR_ORDER_NUMBER = "Repair_Order_number";
        public static final String COLUMN_WRITER = "writer";
        public static final String COLUMN_CUSTOMER = "customer";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_LABOR_RATE = "labor_rate";
        public static final String COLUMN_HOURS = "hours";
        public static final String COLUMN_GROSS = "gross";
        public static final String COLUMN_MAKE = "make";
        public static final String COLUMN_MODEL = "model";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_MILEAGE = "mileage";
        public static final String COLUMN_VIN = "vin";
        public static final String COLUMN_COLOR = "color";
        public static final String COLUMN_LICENSE = "license";

    }
}