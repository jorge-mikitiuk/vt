package ar.gob.mehac.dgsiaf.ing.tv;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;

import org.xml.sax.InputSource;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;

public class RSSConsumer {

  public static void main(String[] args) {
    //
    // final String authUser = "jmikit_mecon";
    // final String authPassword = args[0];
    //
    // Authenticator.setDefault(new Authenticator() {
    //
    // @Override
    // public PasswordAuthentication getPasswordAuthentication() {
    // return new PasswordAuthentication(authUser, authPassword.toCharArray());
    // }
    // });

    try {
      URL url = new URL("https://www.oracle.com/corporate/press/rss/rss-pr.xml");
      Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("proxypool1.mecon.ar", 8080));
      URLConnection connection = url.openConnection(proxy);
      InputStream inputStream = connection.getInputStream();
      SyndFeed feed = new SyndFeedInput().build(new InputSource(inputStream));

      System.out.println(feed.getTitle());
      System.out.println(feed.getFeedType());

      System.out.println("***********************************");
      for (SyndEntry entry : feed.getEntries()) {
        // if (entry.getDescription().getValue().contains("ydelfino")) {
        System.out.println(entry);
        System.out.println("***********************************");
        // }
      }
      System.out.println("Done");

      inputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
