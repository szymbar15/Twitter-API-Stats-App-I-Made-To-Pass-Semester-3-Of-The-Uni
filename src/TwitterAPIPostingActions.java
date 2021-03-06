import java.io.File;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterAPIPostingActions {

	public static void writeATextTweet(String text) throws TwitterException {
		StatusUpdate status = new StatusUpdate(text);
		InitializeTwitterInstance.twitter.updateStatus(status);
		System.out.println("Managed to acquire and post data related to user.");
	}

	public static void writeATweetContainingAPic(String text, File a) throws TwitterException {
		StatusUpdate status = new StatusUpdate(text);
		status.setMedia(a);
		Status status2 = InitializeTwitterInstance.twitter.updateStatus(status);
		System.out.println("Wrote a Tweet [" + status2.getText().substring(0, Math.min(status2.getText().length(), 50))
				+ "...] with a chart " + a.getName() + ". URL: "
				+ status2.getText().substring(status2.getText().lastIndexOf("https")));
	}
	
}
