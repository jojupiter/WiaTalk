package com.example.fofe.wiatalk.Sms;

import android.support.v4.app.Fragment;


public class smsFragment extends Fragment {


/*

    private View v;
    private  static RecyclerView myrecyclerView;
    private   static RecyclerViewAdapterMessage recyclerViewAdapterMessage;
    private static List<Sms> lsSms;
    public smsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
v= inflater.inflate(R.layout.fragment_sms, container, false);
        myrecyclerView= (RecyclerView)v.findViewById(R.id.contactRecycler);
         recyclerViewAdapterMessage = new RecyclerViewAdapterMessage(getContext(),lsSms);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapterMessage);
        return v ;
    }

/*
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser ) {
            // Refresh your fragment here
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
            Log.e("REFRECH smsFragment", "REFRECH SUCESS");
        }
    }

*/
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lsSms= new ArrayList<>();
    }

    public static void showMessages(DatabaseManager databaseManager,String discussion){

        String sql = "SELECT time_sent,time_receive,emetter,receiver,TextMsg FROM Sms WHERE Discussion=\""+discussion+"\" ";
        Cursor cursor = databaseManager.getReadableDatabase().rawQuery(sql,null);
        while (cursor.moveToNext()) {


            String time_sent = cursor.getString(0);
            String time_receive = cursor.getString(1);
            String emetter = cursor.getString(2);
            String receiver = cursor.getString(3);
            String textMsg= cursor.getString(4);

            Sms sms = new Sms(time_sent, time_receive, emetter, receiver,textMsg,discussion);
            lsSms.add(sms);
        }
    }

    public  static void refrechRecycler( Sms newSms){
         recyclerViewAdapterMessage.getLsSms().add(newSms);
         recyclerViewAdapterMessage.notifyDataSetChanged();
       //  myrecyclerView.scrollToPosition(recyclerViewAdapterMessage.getItemCount()-1);

    }


*/
}
