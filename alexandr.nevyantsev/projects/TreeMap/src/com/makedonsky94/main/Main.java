package com.makedonsky94.main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeMap<Integer, Character> map = new TreeMap<Integer, Character>() {
            @Override
            public Character put(Integer code, Character character) {
                if(character == 0)
                    return 0;
                return super.put(code, character);
            }
            @Override
            public String toString() {
                ArrayList<Character[]> listChars = new ArrayList<>();
                Collection<Character> collection = this.values();
                Iterator<Character> i = collection.iterator();
                int currentIndex = 1;

                for(;;) {
                    if(!i.hasNext())
                        break;
                    int localIndex = 0;
                    Character[] localArray = new Character[currentIndex];
                    while(currentIndex != localIndex) {
                        try {
                            localArray[localIndex] = i.next();
                        } catch(NoSuchElementException ex) {
                            localArray[localIndex] = '*';
                        }
                        localIndex++;
                    }
                    listChars.add(localArray);
                    currentIndex += 2;
                }

                String str = "";
                for(Character[] chars : listChars) {
                    StringBuilder stringMargins = new StringBuilder();
                    for(int i1 = 0; i1 < currentIndex + 4; i1++) {
                        stringMargins.append(" ");
                    }
                    currentIndex -= 3;
                    StringBuilder builder = new StringBuilder();
                    builder.append(stringMargins.toString());
                    String rowString = Arrays.toString(chars);
                    builder.append(rowString);
                    builder.append("\n");
                    str +=  builder.toString();
                }
                return str;
            }
        };
        for(int i = 0; i < 50; i++) {
            map.put(i, 'a');
        }

        System.out.println(map.toString());
    }
}
