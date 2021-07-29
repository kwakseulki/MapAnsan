package com.seulki.mapansan.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = 6;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
        PlaceholderItem placeholderItem = null;
        String details = null;
        if (position==1) {
            details = "설명" +
                    "\n설명";
            placeholderItem = new PlaceholderItem(String.valueOf(position), "대부바다향기테마파크",details);
        }
        else if (position==2){
            details = "설명" +
                    "\n설명";
            placeholderItem = new PlaceholderItem(String.valueOf(position), "안산갈대습지공원",details);
        }
        else if (position==3){
            details = "설명" +
                    "\n설명";
            placeholderItem = new PlaceholderItem(String.valueOf(position), "안산호수공원",details);
        }
        else if (position==4){
            details = "설명" +
                    "\n설명";
            placeholderItem = new PlaceholderItem(String.valueOf(position), "별빛마을포토랜드",details);
        }
        else if (position==5){
            details = "설명" +
                    "\n설명";
            placeholderItem = new PlaceholderItem(String.valueOf(position), "화랑유원지",details);
        }
        else if (position==6){
            details = "설명" +
                    "\n설명";
            placeholderItem = new PlaceholderItem(String.valueOf(position), "누에섬",details);
        }
        return placeholderItem;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;

        public PlaceholderItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}