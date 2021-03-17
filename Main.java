import java.util.*;

public class Main {

    public static void main(String[] args) {

        //TEST: simpleStringReversal2  - should return 'cawedors'
        System.out.print("Solution to simpleStringReversal2: ");
        System.out.println(simpleStringReversal2("codewars", 1, 5));

        //ArrayList Setup for arrayElementParity test
        ArrayList<Integer> arrayElementParityList = new ArrayList<>();
        arrayElementParityList.add(1);
        arrayElementParityList.add(2);
        arrayElementParityList.add(3);
        arrayElementParityList.add(-1);
        arrayElementParityList.add(-2);

        //TEST: arrayElementParity - should return 3
        System.out.print("Solution to arrayElementParity: ");
        System.out.println(arrayElementParity(arrayElementParityList));

        //ArrayList Setup for circleOfNumbers test (contains ints 0-9)
        ArrayList<Integer> circleOfNumberslist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            circleOfNumberslist.add(i);
        }

        //TEST: circleOfNumbers - should return 2
        System.out.print("Solution to circleOfNumbers: ");
        System.out.println(circleOfNumbers(circleOfNumberslist, 7));

        //TEST: twoToOne - should return 'abcdefklmopqwxy'
        System.out.print("Solution to twoToOne: ");
        System.out.println(twoToOne("xyaabbbccccdefww", "xxxxyyyyabklmopq"));

    }

    private static String simpleStringReversal2(String s, int start, int finish) {
        StringBuilder sb = new StringBuilder();
        //append front
        sb.append(s.substring(0, start));
        //append reversed middle
        sb.append(new StringBuilder(s.substring(start, finish + 1)).reverse().toString());
        // append back
        sb.append(s.substring(finish + 1));
        return sb.toString();

    }

    private static int arrayElementParity(ArrayList<Integer> list) {

        HashSet<Integer> set = new HashSet<>(list);
        for (int i : list) {
            if (!set.contains(i * -1)) {
                return i;
            }
        }
        //If the input list is set up the way the test specifies, this return statement will never be reached.
        return 0;
    }

    private static int circleOfNumbers(ArrayList<Integer> list, int firstNumber) {
        int index;
        //if firstnumber + (listsize/2) is greater than the total list size,
        //then subtract list size to 'round the horn'
        if (firstNumber + (list.size() / 2) > list.size()) {
            index = (firstNumber + (list.size() / 2)) - list.size();
            return (list.get(index));
        }
        //otherwise just return the index that equals firstNumber + list.size()/2
        else {
            index = firstNumber + (list.size() / 2);
            return (list.get(index));
        }
    }

    private static String twoToOne(String s1, String s2) {
        //concatenate the 2 input strings
        String combined = s1 + s2;

        //convert to char array
        char[] chars = combined.toCharArray();

        //sort into alphabetical order
        Arrays.sort(chars);

        // remove duplicates
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }

        //convert back to string
        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }

        return sb.toString();
    }
}
