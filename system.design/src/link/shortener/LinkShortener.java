package link.shortener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LinkShortener {
    Map<String, String> links;

    public static void main(String[] args) {
        Map<String, String> links = new HashMap<>();
        links.put("ab", "");
        links.put("ba", "");
        String shortUrl = encode("http://www.looooooooongUrllllll.com/looongverylooonguuuurll", links);
        System.out.println(decode(shortUrl, links));
    }

    //@Post(/shorten-link)
    public static String encode(String longUrl, Map<String, String> links){
        boolean isUnique = false;
        String shortLink = "";
        while (!isUnique){
            shortLink = generateRandomShortLink();
            isUnique = !links.containsKey(shortLink);
        }
        generateRandomShortLink();
        System.out.println(shortLink);
        links.put(shortLink, longUrl);
        return shortLink;
    }

    //@Get(/navigate-to-url)
    public static String decode(String shortUrl, Map<String, String> links){
        return links.get(shortUrl);
    }

    private static String generateRandomShortLink(){
        String alpha = "abcdefghijklmnopqrstuvwxyz1234567890";
        //this can be provided from customer side
        int[] stringLength = new int[]{4,5,6,7,8,9};
        StringBuilder randomString = new StringBuilder();
        int length = stringLength[ThreadLocalRandom.current().nextInt(0, stringLength.length)];
        for (int i = 0; i < length; i++){
            randomString.append(alpha.charAt(ThreadLocalRandom.current().nextInt(0, alpha.length())));
        }
        return String.format("http://www.shrtme.com/%s", randomString);


    }


}
