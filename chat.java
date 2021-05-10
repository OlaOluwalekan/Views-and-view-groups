package com.icode.viewandviewgroups;

import android.app.*;
import android.widget.*;
import android.os.*;
import android.view.*;
import android.view.ViewGroup;
import android.content.*;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;


public class chat extends Activity
{
	ListView listview1;
	//items to show in listview
	String[] items = {"Chelsea", "Arsenal", "Manchester City", "Manchester United", "Liverpool" };
	Integer [] logo = {R.drawable.chelsea_logo, R.drawable.arsenal_logo, R.drawable.mancity_logo, R.drawable.manu_logo, R.drawable.liverpool_logo}; 

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.chat);
		//call the CustomAdapter constructor and pass the values you want to be shown in the listview 
		CustomAdapter adapter = new CustomAdapter(chat.this, items, logo);
		listview1 = (ListView)findViewById(R.id.listview1);
		listview1.setAdapter(adapter);
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override 
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					String  itemValue    = (String) listview1.getItemAtPosition(position);
					Toast.makeText(chat.this, itemValue, Toast.LENGTH_SHORT).show();
				} 
			}); 
	} 
}
//create a seperate ArrayAdapter class for your specific layout design for the listview 
class CustomAdapter extends ArrayAdapter<String> {
	private final Context context; 
	private final String[] items; 
	private final Integer[] logo;
	//the constructor gets the values to be shown on the listview 
	public CustomAdapter(Context context, String[] items, Integer[] logo) { 
		super(context, R.layout.custom_layout, items); 
		this.context = context; 
		this.items = items; 
		this.logo = logo; 
	}
	//getview method inflates the values given from the mainactivity on the custom design layout for listview and returns the layout with inflated values in it 
	@Override 
	public View getView(int position, View view, ViewGroup parent) { 
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		View rowView= inflater.inflate(R.layout.custom_layout, null, true);
		//initialize the textview and imageview we declared in the custom_list.xml file
		TextView title = (TextView) rowView.findViewById(R.id.text);
		ImageView image = (ImageView) rowView.findViewById(R.id.image);
		title.setText(items[position]);
		image.setImageResource(logo[position]);
		return rowView; 
	} 
} 
	
	/*import android.app.*;
	 import android.widget.*;
	 import android.os.*;
	 import android.view.*;
	ListView chat_list_view;
	String[] items = {"John Mark", "Sammy Bloom", "Xyluz", "Abbie"};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);

		chat_list_view = findViewById(R.id.chat_list_view);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
		chat_list_view.setAdapter(adapter);

		chat_list_view.setOnItemClickListener((new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				int itemPosition = position;
				String  itemValue    = (String) chat_list_view.getItemAtPosition(position);
				Toast.makeText(getApplicationContext(), "Position:"+itemPosition+"  Item Clicked: " +itemValue , Toast.LENGTH_LONG).show(); 
			}
		}));
	}
}*/
