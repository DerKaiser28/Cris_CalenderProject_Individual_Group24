package cosc310project_scheduling;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class scheduleSports{
	
	private league l;
	private String teamName;
	
	String[] apiLeagueURLArray = {"https://v1.american-football.api-sports.io/","","",""};
	
	public scheduleSports(league l, String team) {
		this.l = l;
		this.teamName = team;
	}

	public ArrayList<event> getGames() {
		
		ArrayList<event> ale = new ArrayList<event>();
		
		try {
			String teamEndpoint_url = getURL(l) + "teams?search=" + teamName;

			OkHttpClient client = new OkHttpClient.Builder().readTimeout(1, TimeUnit.SECONDS).build();

			Request request = new Request.Builder().url(teamEndpoint_url)
					.addHeader("x-apisports-key", "95f84fcdfd671980cce4c3b1903b9b18").build();

			Call call = client.newCall(request);
			Response response = call.execute();

			String jsonData = response.body().string();
			JSONObject jobj = new JSONObject(jsonData);
			JSONArray responseArray = jobj.getJSONArray("response");
			
			JSONObject object = responseArray.getJSONObject(0);

			int id = object.getInt("id");
			
			String gameEndpoint_url = getURL(l) + "games?season=2022&team=17";
			
			request = new Request.Builder().url(gameEndpoint_url)
					.addHeader("x-apisports-key", "95f84fcdfd671980cce4c3b1903b9b18").build();
			
			call = client.newCall(request);
			response = call.execute();
			
			jsonData = response.body().string();
			jobj = new JSONObject(jsonData);
			
			responseArray = jobj.getJSONArray("response");
			
			for (int i = 0; i < responseArray.length(); i++) {
				JSONObject ja = responseArray.getJSONObject(i);
				String home = ja.getJSONObject("teams").getJSONObject("home").getString("name");
				String away = ja.getJSONObject("teams").getJSONObject("away").getString("name");
					
				String gameName = away + " @ " + home;
				
				String location = ja.getJSONObject("game").getJSONObject("venue").getString("name");
				
				long timestamp = ja.getJSONObject("game").getJSONObject("date").getLong("timestamp");
				
				event e = new event(gameName, location, timestamp);
				ale.add(e);
				
				//System.out.println(i + " " +  e.getName());
			}

		} catch (Exception e) {
			System.err.println("FATAL ERROR(ss-gg): "+e);
		}
		
		return ale;

	}
	
	private String getURL(league l) {
		switch(l) {
			case NFL: return apiLeagueURLArray[0];
			case NBA: return apiLeagueURLArray[1];
			case NHL: return apiLeagueURLArray[2];
			case MLB: return apiLeagueURLArray[3];
			default: return "null";
		}
	}
	
	
}
