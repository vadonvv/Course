package ru.vvv.my_desktop_utils;

import java.util.Comparator;

public enum DesktopItemComparator implements Comparator<DesktopItem> {
    NAME_SORT {
        public int compare(DesktopItem o1, DesktopItem o2) {
            if(o1 == null || o2 == null){
                return o1 == null ? 1 : -1;
            }
            return o1.getName().compareTo(o2.getName());
        }},
    COST_SORT {
        public int compare(DesktopItem o1, DesktopItem o2) {
            if(o1 == null || o2 ==null){
                return o1 == null ? 1 : -1;
            }
            return Integer.compare(o1.getCost(), o2.getCost());
        }
    };

    public static Comparator<DesktopItem> decending(final Comparator<DesktopItem> other) {
        return new Comparator<DesktopItem>() {
            public int compare(DesktopItem o1, DesktopItem o2) {
                return -1 * other.compare(o1, o2);
            }
        };
    }
    public static Comparator<DesktopItem> getComparator(final DesktopItemComparator... multipleOptions){
        return  new Comparator<DesktopItem>() {
            @Override
            public int compare(DesktopItem o1, DesktopItem o2) {
                for (DesktopItemComparator option:
                     multipleOptions) {
                    int result = option.compare(o1,o2);
                    if(result != 0){
                        return result;
                    }
                }
                return 0;
            }
        };
    }


}
