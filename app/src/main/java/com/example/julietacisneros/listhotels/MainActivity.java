package com.example.julietacisneros.listhotels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListEntry> hotels = new ArrayList<ListEntry>();

        hotels.add(new ListEntry(R.drawable.hotel, "Sheraton", "5 puntos", "22n9@y0a7CmKQsVHZkW0VQ5M%GEmPtQZ[e@TIakGWdOg#]Cu04p56i84sO5tv!K@dH8xz(U^*(0HBtwcuiHilteb4LOu[]8)AemW9%8otzFpZNBlYner#j4PDP%OXQr^h]0^QF2#91ah2m)$Zw8)koeMLXNG7yFzNAc^!YTa843&[WgU)FcSO$ChZzp9R]g[k@&QHNCukidg#TNKbZmxthehE5S!ts*ysb7NLZn$fya2wNBppgLk*Ii]UlVqSZx0L)mS&OW)q7B4Y4Wx]R21Kv8Z&i3@#Dco0w]&3x4cabMa[k]18[)AJqk9jrX%y)09xX]iDF4X2BJCP&O#sHr3g)U]X][f#%nNmBh9hJ2VYr0n!HVLsLM%Ke88(D2!UOmMWa@Gn)@a88uXjv^OlXDJtoFmiaj9J4Z0ldZR$zuo(aiaT2te&C7lACEV1z0cHs%Jj]cy%gUJm4]QP7W75z9WnSdRdITi*[pNSIK#oPt1eqSb3C5ErTCJSur783ei8FgeD)M6neYVBy!%emLl6Y!IPQUd%IKAkX*aVc[GMdkHIJaF)e@5#afRc29bH]fn)YB2ON02V]NWjPdcGfWy2q#lIsEDy!M8hcVh9vBG9Mhl#fUh7hlq#ui0HciAs%0sMc$RuztvhKFf56y8[37N$Lfjt[61i^eKqcZj$j61jXhg5HsYq9X*p51]qFTp@M(0f"));
        hotels.add(new ListEntry(R.drawable.hotel, "H&H", "11 puntos", "22n9@y0a7CmKQsVHZkW0VQ5M%GEmPtQZ[e@TIakGWdOg#]Cu04p56i84sO5tv!K@dH8xz(U^*(0HBtwcuiHilteb4LOu[]8)AemW9%8otzFpZNBlYner#j4PDP%OXQr^h]0^QF2#91ah2m)$Zw8)koeMLXNG7yFzNAc^!YTa843&[WgU)FcSO$ChZzp9R]g[k@&QHNCukidg#TNKbZmxthehE5S!ts*ysb7NLZn$fya2wNBppgLk*Ii]UlVqSZx0L)mS&OW)q7B4Y4Wx]R21Kv8Z&i3@#Dco0w]&3x4cabMa[k]18[)AJqk9jrX%y)09xX]iDF4X2BJCP&O#sHr3g)U]X][f#%nNmBh9hJ2VYr0n!HVLsLM%Ke88(D2!UOmMWa@Gn)@a88uXjv^OlXDJtoFmiaj9J4Z0ldZR$zuo(aiaT2te&C7lACEV1z0cHs%Jj]cy%gUJm4]QP7W75z9WnSdRdITi*[pNSIK#oPt1eqSb3C5ErTCJSur783ei8FgeD)M6neYVBy!%emLl6Y!IPQUd%IKAkX*aVc[GMdkHIJaF)e@5#afRc29bH]fn)YB2ON02V]NWjPdcGfWy2q#lIsEDy!M8hcVh9vBG9Mhl#fUh7hlq#ui0HciAs%0sMc$RuztvhKFf56y8[37N$Lfjt[61i^eKqcZj$j61jXhg5HsYq9X*p51]qFTp@M(0f"));

        list = (ListView) findViewById(R.id.item);

        list.setAdapter(new CustomListAdapter(this, R.layout.item, hotels) {
            @Override
            public void onEntry(Object entry, View view) {
                if (entry != null) {
                    TextView hotelName = (TextView) view.findViewById(R.id.name);
                    hotelName.setText(((ListEntry) entry).getHotelName());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.punctuationMain);
                    texto_inferior_entrada.setText(((ListEntry) entry).getPunctuation());

                    ImageView hotelImage = (ImageView) view.findViewById(R.id.image);
                    hotelImage.setImageResource(((ListEntry) entry).getImage());
                }
            }
        });

        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListEntry selected = (ListEntry) parent.getItemAtPosition(position);

                Intent intent = new Intent(getBaseContext(), HotelDetailsActivity.class);
                intent.putExtra("image", selected.getImage());
                intent.putExtra("description", selected.getDescription());
                intent.putExtra("punctuation", selected.getPunctuation());
                intent.putExtra("name", selected.getHotelName());

                startActivity(intent);
            }
        });
    }
}
