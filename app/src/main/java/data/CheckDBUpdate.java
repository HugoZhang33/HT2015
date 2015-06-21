package data;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class CheckDBUpdate {
	public boolean needUpdate;
	

	public boolean compare() {
		String result = getTimestamp();
		if (result.compareTo(Conference.timstamp) == 0)
			needUpdate=false;
		else {
			needUpdate = true;
			Conference.timstamp =result;
		}

		return needUpdate;
	}

	public boolean check() {
		String result = getTimestamp();
		if (result.compareTo(Conference.timstamp) == 0)
			needUpdate=false;
		else {
			needUpdate = true;
		}

		return needUpdate;
	}

	public String getTimestamp() {
		String url = ConferenceURL.CheckUpdate;
		HttpPost httpRequest = new HttpPost(url);
		String result = null;

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("eventID", Conference.id));
		try {

			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

			HttpResponse httpResponse = new DefaultHttpClient()
					.execute(httpRequest);

			if (httpResponse.getStatusLine().getStatusCode() == 200) {

				result = EntityUtils.toString(httpResponse.getEntity());
				int start = result.indexOf("<timestamp>");
				int end = result.indexOf("</timestamp>");
				result = result.substring(start+11, end);
			} else {
				// System.out.print("error: status code not 200");
				needUpdate = false;
			}
		} catch (Exception e) {
			System.out.print("exception" + e);
		}

		return result;
	}
}

