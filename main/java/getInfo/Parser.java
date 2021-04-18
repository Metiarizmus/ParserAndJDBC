package getInfo;

import Entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    public static void main(String[] args) {
        for (String q : setNameBook())
        System.out.println(q);
    }

    private static Document selDoc(){
        Document document = null;
        try {
             document = Jsoup.connect("https://oz.by/sseries/more150772.html").get();
        } catch (IOException e) {
            System.out.println("url error");
            e.printStackTrace();
        }
        return document;
    }

    public  ArrayList<String> setUrlBook() {
        ArrayList<String> list = new ArrayList<>();
        Elements el = selDoc().getElementsByAttributeValue("class","item-type-card__inner");


        for (Element q : el) {
            Element aEl = q.child(0);
            String url = aEl.attr("href");
            list.add(url);
        }

        return list;

    }

    public static   ArrayList<String> setNameBook() {
        ArrayList<String> list = new ArrayList<>();
        Elements el = selDoc().select("a[class=item-type-card__link]");

        for (Element q : el) {
            Element pEl = q.child(0);
            list.add(pEl.text());
        }
        return list;
    }

    public  ArrayList<String> setAuthorBook() {
        ArrayList<String> list = new ArrayList<>();
        Elements el = selDoc().select("p[class=item-type-card__info]");

        for (Element q : el) {
            String s = q.text().replaceAll("[^а-яА-Я\s]","");
            list.add(s);
        }
        return list;
    }

    public  ArrayList<String> setDataBook() {
        ArrayList<String> list = new ArrayList<>();
        Elements el = selDoc().select("p[class=item-type-card__info]");

        for (Element q : el) {
            String s = q.text().replaceAll("[а-яА-Я\\W]","");
            list.add(s);
        }
        return list;
    }

    public  ArrayList<String> setCostBook() {
        ArrayList<String> list = new ArrayList<>();
        Elements el = selDoc().select("div[class=item-type-card__cost]");

        for (Element q : el) {
            String s = q.text();
            list.add(s);
        }
        return list;
    }


}
