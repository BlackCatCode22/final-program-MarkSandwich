import org.jsoup.Jsoup; //Discovered Jsoup and Elements from https://www.scrapingbee.com/blog/java-parse-html-jsoup/
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.print("Spotify Playlist Searcher\nHow many songs would you like to enter? ");
        boolean intValue = false;
        String combined = "";

        while (!intValue) { //A while loop to ensure the user inputs only numbers
            String numOfSongs = new Scanner(System.in).nextLine();
            if (numOfSongs.matches("[0-9]+")) { //Makes sure the input is only made of numbers
                for (int i = 1; i <= Integer.parseInt(numOfSongs); i++) { //Prompts user to input their desired songs until the number of entered songs matches the number of requested songs
                    System.out.print("Enter the name of song " + i + ": ");
                    combined += "\"" + new Scanner(System.in).nextLine() + "\" "; //Adds entered song titles to a string containing all the titles
                }
                for (Element link : Jsoup.connect(String.valueOf(new URI("https", "google.com", "/search?hl=en&q=site:open.spotify.com/playlist/ " + subPrompt("Would you like to exclude playlists created by Spotify? ", subPrompt("Would you like to exclude playlists over 24 hours? ", " -\"over 24 hr\"") + " -\"playlist by Spotify\"") + combined, "")).replace("%3F", "?")).userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:105.0) Gecko/20100101 Firefox/105").timeout(6000).get().select("a[href]")) {
                    //Forms the path to download via the subPrompt method and the combined single string. The URI method creates full links, which cannot be done via adding to string. Creating this full link with URI also encodes certain characters. In this instance ? is replaced with %3F. This has to changed however, since scraping the web results with an error. The .replace() method is used to revert this. The .valueOf() method is used get the string value of the URI since .connect() only takes in strings. The .select() method is used to only scrape links.
                    if (link.attr("href").contains("https://open.spotify.com")) { //Filters out the links that are not Spotify playlist links
                        System.out.println(link.text().split("spotify.com")[0] + link.attr("href")); //Prints out the title of the playlist and provides a hyperlink to easily copy to pasteboard or open link in browser by clicking on it.
                    }
                }
                intValue = true; //Breaks the loop after the user input is all numbers, all the song titles are added to a single string, and the web results are scraped
            }
            System.out.print("Please enter a number "); //If the input does not contain only numbers, the user is prompted to enter the input again
        }
    }
    //Have error message if no results

    public static String subPrompt(String prompt, String add) { //Prompts user if they want to remove certain results from the search
        System.out.print(prompt);
        if (new Scanner(System.in).nextLine().matches("(?i)yes||y")) { //If user enters yes, y, or hits enter, the URL adds on the string to subtract searches from Google.
            return add;
        }
        return "";
    }
}
